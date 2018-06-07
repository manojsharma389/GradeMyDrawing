package application.com.controller;

import application.com.model.ErrorDTO;
import application.com.model.ResponseDTO;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.naming.AuthenticationException;
import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class BaseController {

    private static final String VALIDATION_ERROR_CODE = "ValidationError";

    // Helper Method To read message from messages.properties file -- STARTS--
    @Autowired
    private MessageSource messageSource;

    private static final String EMPTY = "";


    public String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
        return messageSource.getMessage(code, args, defaultMessage, locale);
    }

    public String getMessage(String code, Object[] args, Locale locale) throws NoSuchMessageException {
        return messageSource.getMessage(code, args, locale);
    }

    public String getMessage(MessageSourceResolvable resolvable, Locale locale) throws NoSuchMessageException {
        return messageSource.getMessage(resolvable, locale);
    }

    public String getMessage(String messageKey) {
        return getMessage(messageKey, EMPTY);
    }

    public String getMessage(String messageKey, Object... args) {
        return messageSource.getMessage(messageKey, args, LocaleContextHolder.getLocale());
    }
    // Helper Method To read message from messages.properties file -- ENDS--


    // Helper Method To Handle Exception -- STARTS--
    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseDTO<String>> handleException(HttpMessageNotReadableException exception) {
        //log.error("******** Inside HttpMessageNotReadableException Handler ************");
        ResponseDTO<String> responseDTO = new ResponseDTO<String>();
        responseDTO.setStatus(Boolean.FALSE);
        responseDTO.setMessage(getMessage("invalid.request", null, "Please provide valid request", LocaleContextHolder.getLocale()));
        ErrorDTO errorDTO = new ErrorDTO(HttpMessageNotReadableException.class.getSimpleName(), exception.getMessage());
        responseDTO.setErrors(Collections.singletonList(errorDTO));
        exception.printStackTrace();
        return new ResponseEntity<ResponseDTO<String>>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseDTO<String>> handleException(MethodArgumentNotValidException exception) {
//        log.error("******** Inside MethodArgumentNotValidException Handler ************");
        exception.printStackTrace();
        return new ResponseEntity<ResponseDTO<String>>(createValidationError(exception), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(FileNotFoundException exc) {
//        return ResponseEntity.notFound().build();
        return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException exc) {
//        return ResponseEntity.notFound().build();
        return new ResponseEntity<>(exc.getCause().getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> handleAccessDeniedException(AccessDeniedException exc) {
//        return ResponseEntity.notFound().build();
        return new ResponseEntity<>(exc.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<?> handleAccessDeniedException(AuthenticationException exc) {
//        return ResponseEntity.notFound().build();
        return new ResponseEntity<>(exc.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<?> handleException(ArithmeticException exc) {
//        return ResponseEntity.notFound().build();
        return new ResponseEntity<>(exc.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleAllException(Exception e) {
//        return ResponseEntity.notFound().build();
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    private ResponseDTO<String> createValidationError(MethodArgumentNotValidException exception) {
        return fromBindingErrors(exception.getBindingResult());
    }
    // Helper Method To Handle Exception -- ENDS--

    // Helper Method Error Binding -- STARTS--

    private ResponseDTO<String> fromBindingErrors(Errors errors) {
        Locale currentLocale = LocaleContextHolder.getLocale();
        ResponseDTO<String> errorResponseDTO = new ResponseDTO<String>();
        errorResponseDTO.setStatus(Boolean.FALSE);
        errorResponseDTO.setMessage("Invalid Request. Validation failed. " + errors.getErrorCount() + " error(s)");
        List<ErrorDTO> errorDTOs = errors.getAllErrors()
                .stream()
                .map(objectError -> getErrorDTO(currentLocale, objectError))
                .collect(Collectors.toList());
        errorResponseDTO.setErrors(errorDTOs);
        return errorResponseDTO;
    }

    private ErrorDTO getErrorDTO(Locale currentLocale, ObjectError objectError) {
        String errorMessageOrErrorCode = objectError.getDefaultMessage();
        if (StringUtils.isEmpty(errorMessageOrErrorCode)) {
            errorMessageOrErrorCode = "validation.error";
        }
        return new ErrorDTO(VALIDATION_ERROR_CODE, getMessage(errorMessageOrErrorCode, objectError.getArguments(), errorMessageOrErrorCode, currentLocale));
    }
    // Helper Method Error Binding -- ENDS--

    public void setFlashMessageOnStatus(ResponseDTO responseDTO, RedirectAttributes redirectAttributes) {
        redirectAttributes = responseDTO.getStatus() ? redirectAttributes.addFlashAttribute("success", responseDTO.getMessage()) :
                redirectAttributes.addFlashAttribute("error", responseDTO.getMessage());
    }
}
