public class Transaction {
    private int transfered_from_bank_id;
    private int transfered_to_bank_id;
    private int amount_transfered;


    public Transaction() {

    }

    public Transaction(int transfered_from_bank_id, int transfered_to_bank_id, int amount_transfered) {
        this.transfered_from_bank_id = transfered_from_bank_id;
        this.transfered_to_bank_id = transfered_to_bank_id;
        this.amount_transfered = amount_transfered;
    }

    public int getTransfered_from_bank_id() {
        return transfered_from_bank_id;
    }

    public void setTransfered_from_bank_id(int transfered_from_bank_id) {
        this.transfered_from_bank_id = transfered_from_bank_id;
    }

    public int getTransfered_to_bank_id() {
        return transfered_to_bank_id;
    }

    public void setTransfered_to_bank_id(int transfered_to_bank_id) {
        this.transfered_to_bank_id = transfered_to_bank_id;
    }

    public int getAmount_transfered() {
        return amount_transfered;
    }

    public void setAmount_transfered(int amount_transfered) {
        this.amount_transfered = amount_transfered;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transfered_from_bank_id=" + transfered_from_bank_id +
                ", transfered_to_bank_id=" + transfered_to_bank_id +
                ", amount_transfered=" + amount_transfered +
                '}';
    }
}


