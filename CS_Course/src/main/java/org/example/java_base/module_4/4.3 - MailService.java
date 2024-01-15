package org.example.java_base// 4.3 - Реализация работы почтового сервиса

public static class UntrustworthyMailWorker implements MailService{
    
    private MailService[] msArray;
    private RealMailService mRealMailService;
    public UntrustworthyMailWorker(MailService[] mService){
        msArray = mService;
        mRealMailService = new RealMailService();
    }
    
    public RealMailService getRealMailService(){
        return mRealMailService;
    }
    
    @Override
    public Sendable processMail(Sendable mail) {
        Sendable buff = null;
        for (int i = 0; i < this.msArray.length; i++) {

            if (i == 0) {
                buff = this.msArray[0].processMail(mail);
                continue;
            }

            buff = this.msArray[i].processMail(buff);
        }
        return getRealMailService().processMail(buff);

    }    
}


public static  class Spy implements MailService{
    
    private  java.util.logging.Logger SpyLogger = null;
    
    public Spy(java.util.logging.Logger msLogger){
        SpyLogger = msLogger;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        
        if (mail instanceof MailMessage) {
            if (mail.getFrom().equals("Austin Powers") || mail.getTo().equals("Austin Powers")) {
                SpyLogger.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"", new Object[] {mail.getFrom(), mail.getTo(), ((MailMessage) mail).getMessage()});
            } else {
                SpyLogger.log(Level.INFO, "Usual correspondence: from {0} to {1}", new Object[] {mail.getFrom(), mail.getTo()});
            }
        }
        return mail;        
    }    
}


public static class Thief implements MailService {

        private int CostValue = 0;
        private int TotalCost = 0;
        MailPackage mailPackage;

        public Thief(int value) {
            this.CostValue = value;
        }

        @Override
        public Sendable processMail(Sendable mail) {

            if (mail instanceof MailPackage) {
                if (((MailPackage) mail).getContent().getPrice() >= CostValue) {
                    TotalCost += ((MailPackage) mail).getContent().getPrice();
                    MailPackage mailPackage = new MailPackage( mail.getFrom(), mail.getTo(),new Package("stones instead of " + (((MailPackage) mail).getContent().getContent()).toString(), 0));
                    return mailPackage;
                }
                else {
                    return (MailPackage)mail;
                }
            }
            return mail;
        }

        public int getStolenValue() {
            return TotalCost;
        }
    }


public static class Inspector implements MailService{
    
    
    @Override
    public Sendable processMail(Sendable mail) throws IllegalPackageException,StolenPackageException {
        String mpContent;
        if (mail instanceof MailPackage) {
            mpContent = ((MailPackage) mail).getContent().getContent();
                if (mpContent.contains("weapons")||mpContent.contains("banned substance")) {
                    throw new IllegalPackageException();
                }
                if (mpContent.contains("stones")) {
                    throw new StolenPackageException();
                }
            }
            return mail;
    }    
}

public static class IllegalPackageException extends RuntimeException {
}  
public static class StolenPackageException extends RuntimeException { 
}

