package ua.ptah.certifications.hackerrank.vanhack.DigitalWallet;

class DigitalWalletTransaction {

  static void addMoney(DigitalWallet digitalWallet, int amount) throws TransactionException {
    if (amount <= 0) {
      throw new TransactionException(TransactionExceptionCode.INVALID_AMOUNT);
    }
    if (digitalWallet.getUserAccessToken() == null) {
      throw new TransactionException(TransactionExceptionCode.USER_NOT_AUTHORIZED);
    }
    digitalWallet.setWalletBalance(digitalWallet.getWalletBalance() + amount);
  }

  static void payMoney(DigitalWallet digitalWallet, int amount) throws TransactionException {
    if (amount <= 0) {
      throw new TransactionException(TransactionExceptionCode.INVALID_AMOUNT);
    }
    if ((digitalWallet.getWalletBalance() - amount) < 0) {
      throw new TransactionException(TransactionExceptionCode.INSUFFICIENT_BALANCE);
    }
    if (digitalWallet.getUserAccessToken() == null) {
      throw new TransactionException(TransactionExceptionCode.USER_NOT_AUTHORIZED);
    }
    digitalWallet.setWalletBalance(digitalWallet.getWalletBalance() - amount);
  }
}