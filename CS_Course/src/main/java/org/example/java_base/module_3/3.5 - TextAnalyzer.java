//package org.example.java_base// 3.5 - вам необходимо реализовать три класса,
//// которые реализуют данный интерфейс(TextAnalyzer): SpamAnalyzer, NegativeTextAnalyzer и TooLongTextAnalyzer.
//
//public Label checkLabels(TextAnalyzer[] analyzers, String text) {
//     Label result = Label.OK;
//        for (TextAnalyzer analyzer: analyzers){
//            result = analyzer.processText(text);
//            if (result != Label.OK)
//                break;
//        }
//        return result;
//}
//public abstract class KeywordAnalyzer implements TextAnalyzer {
//protected abstract String[] getKeywords();
//
//    protected abstract Label getLabel();
//
//    @Override
//    public Label processText(String text) {
//        String[] keywords = getKeywords();
//        String[] textArray = text.split("[-!\"#$%&')*+,./;<>?@_`{}~]|[\\\\]|[\\s]|[\\t]");
//        for (String keyword: keywords){
//            for (String word: textArray)
//                if (word.equalsIgnoreCase(keyword))
//                    return getLabel();
//        }
//        return Label.OK;
//    }
//
//}
//
//
//public class NegativeTextAnalyzer extends KeywordAnalyzer {
//
//    private String[] keywords = {":(", "=(", ":|"};
//
//    public NegativeTextAnalyzer(){
//
//    };
//
//    @Override
//    public  String[] getKeywords() {
//        return keywords;
//    }
//
//    @Override
//    protected Label getLabel(){
//        return Label.NEGATIVE_TEXT;
//    }
//
//}
// public class SpamAnalyzer extends KeywordAnalyzer{
//
//    private String[] keywords;
//
//
//    public SpamAnalyzer(String[] keywords){
//        this.keywords = keywords;
//    }
//
//    @Override
//    public  String[] getKeywords() {
//        return keywords;
//    }
//
//    @Override
//    protected Label getLabel(){
//        return Label.SPAM;
//    }
//
//}
//public class TooLongTextAnalyzer implements TextAnalyzer {
//
//    private int maxLength;
//
//
//    public TooLongTextAnalyzer(int maxLength){
//        this.maxLength = maxLength;
//    }
//
//    @Override
//    public Label processText(String text) {
//        if (text.length()>maxLength)
//            return Label.TOO_LONG;
//        else
//            return Label.OK;
//    }
//
//}
