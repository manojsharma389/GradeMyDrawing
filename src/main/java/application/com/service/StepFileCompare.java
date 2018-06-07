package application.com.service;

import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class StepFileCompare implements IStepFileCompare {

    public int compareStepFiles(byte[] studentStepFile, byte[] masterStepFile) {
        File stepFileStudent = new File(new String(studentStepFile));
        File stepFileMaster = new File(new String(masterStepFile));

        new CadexEngine().compute(new String(studentStepFile));

        return 1;
    }
}
