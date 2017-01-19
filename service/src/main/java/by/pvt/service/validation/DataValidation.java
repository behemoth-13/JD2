package by.pvt.service.validation;

import java.util.regex.Pattern;

public class DataValidation {

    /**
     * Только латинские или только русские буквы вплоть до 15-и символов
     * <br/>
     * Only latin or only russian letters up to 15 symbols
     */
    public static final Pattern namePattern = Pattern.compile("(\\A[A-Z]?[a-z]{1,15}\\z)|(\\A[А-Я]?[а-я]{1,15}\\z)");

    /**
     * Только латинские или только русские буквы вплоть до 15-и символов
     * <br/>
     * Only latin or only russian letters up to 15 symbols
     */
    public static final Pattern surnamePattern =
            Pattern.compile("(\\A[A-Z]?[a-z]{1,15}\\z)|(\\A[А-Я]?[а-я]{1,15}\\z)");

    /**
     * Латинские буквы или цифры, от 3-х до 15-и символов
     * <br/>
     * Latin letters or digits at least 3 symbols up to 15
     */
    public static final Pattern loginPattern =
            Pattern.compile("\\A[a-zA-Z0-9]{3,15}\\z");

    /**
     * Латинские буквы, цифры, *, ! или ^,<br/>от 6-и до 15-и символов
     * <br/>
     * Latin letters, digits, *, ! or ^ at least 6<br/>symbols up to 15
     */
    public static final Pattern passwordPattern =
            Pattern.compile("\\A[a-zA-Z0-9_\\*\\!\\^]{6,15}\\z");

    /**
     * Пример: vasia.pupkin@gmail.com.
     * <br/>
     * Examples: vasia.pupkin@gmail.com.
     */
    public static final Pattern emailPattern =
            Pattern.compile("\\A[a-z0-9\\.]{3,25}@[a-z\\.]{3,10}\\.{1}[a-z]{2,5}\\z");

    /**
     * Пример: +375 29 1234567, 123-45-67,<br/>+375 44 123-45-67
     * <br/>
     * Examples: +375 29 1234567, 123-45-67,<br/>+375 44 123-45-67
     */
    public static final Pattern phonePattern =
            Pattern.compile("\\A(\\+\\d{3}\\s\\d{2})?\\s?\\d{3}(-|\\s)?\\d{2}(-|\\s)?\\d{2}\\z");

    /**
     * Только цифры, от 1 до 6 цифр
     * <br/>
     * Only digits, at least 1 digits up to 6
     */
    public static final Pattern countOfKMPattern =
            Pattern.compile("\\A[0-9]{1,6}\\z");

    /**
     * Пример: 5543 TE-5
     * <br/>
     * Examples: 5543 TE-5
     */
    public static final Pattern stateNumberPattern =
            Pattern.compile("\\A[0-9]{4} (A|B|E|І|K|M|H|O|P|C|T|X){2}-[1-7]{1}\\z");

    /**
     * Пример: 5543 TE-5
     * <br/>
     * Examples: 5543 TE-5
     */
    public static final Pattern statusCarPattern =
            Pattern.compile("\\A[0-1]{1}\\z");

    ///////////////////////////////////////////////////////////////











    /**
     * Латинские или русские буквы, цифры, '.', ',' или '-'
     * <br/>
     * Latin or russian letters, digits, '.', ',' or '-'
     */
    public static final Pattern addressPattern =
            Pattern.compile("\\A[A-Za-zА-Яа-я\\d\\s\\.,\\-]{1,250}\\z");

    /**
     * Латинские или русские буквы, цифры, '.', ',' или '-'
     * <br/>
     * Latin or russian letters, digits, '.', ',' or '-'
     */
    public static final Pattern detailsPattern =
            Pattern.compile("\\A[A-Za-zА-Яа-я\\d\\s\\.,\\-]{1,250}\\z");
}
