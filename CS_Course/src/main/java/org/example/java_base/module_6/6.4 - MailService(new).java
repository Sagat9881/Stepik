////6.4 - В этой задаче вам предстоит самостоятельно написать набор классов таким образом,
//// чтобы данный код успешно компилировался и выполнялся.
//
//public interface Sendable<T>{
//        public String getTo();
//        public T getContent();
//    }
//
//public static class MailMessage implements Sendable<String> {
//        private String sFrom;
//        private String sTo;
//        private String sContent;
//        public String getFrom(){
//            return sFrom;
//        }
//
//        public String getTo(){
//            return sTo;
//        }
//
//        public String getContent(){
//            return sContent;
//        }
//        public MailMessage (String From, String To, String Content){
//            sFrom = From;
//            sTo = To;
//            sContent = Content;
//        }
//    }
//
//
//    public static class Salary implements Sendable<Integer> {
//        private String sJob;
//        private String sName;
//        private Integer iSalary;
//
//        public Salary(String Job, String Name, Integer Salary){
//            sJob = Job;
//            sName = Name;
//            iSalary = Salary;
//        }
//
//        public String getTo(){
//            return sName;
//        }
//
//
//        public Integer getContent() {
//            return iSalary;
//        }
//    }
//
//    public static class MailService<T> implements Consumer<Sendable<T>> {
//        private final Map<String, List<T>> msMailBox;
//        public MailService(){
//            msMailBox = new HashMap<String, List<T>>() {
//                @Override
//                @SuppressWarnings("empty-statement")
//                public List<T> get(Object key) {
//                    if (msMailBox.containsKey(key)) {
//                        return msMailBox.getOrDefault(key, null);
//                    } else {
//                        List<T> lst = new LinkedList<>();
//                        msMailBox.put((String)key, lst);
//                        return lst;
//
//                    }
//                }
//            };
//        }
//        public Map<String, List<T>> getMailBox(){
//            return msMailBox;
//        }
//
//        public void accept(Sendable<T> t) {
//            List lst = msMailBox.get(t.getTo());
//            lst.add(t.getContent());
//        }
//    }
//
