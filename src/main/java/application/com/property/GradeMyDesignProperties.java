package application.com.property;

public class GradeMyDesignProperties {

    public static final StringBuilder LIST_FAQ =
            new StringBuilder("from FrequentlyAskedQuestions");

    public static final StringBuilder LIST_SUBSCRIPTION =
            new StringBuilder("from Subscription");

    public static final StringBuilder LIST_PRICING =
            new StringBuilder("from Pricing");
    public static final StringBuilder LIST_STUDENTS_LIKE_USERID =
            new StringBuilder("from Student s where s.userId like :userId");

    public static final StringBuilder LIST_ALL_CLASSES =
            new StringBuilder("from CADClass");

    public static final StringBuilder LIST_Role_ID_BY_USERID =
            new StringBuilder("from UserRole u where  u.userId like :userId");

}
