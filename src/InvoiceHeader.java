import java.util.ArrayList;

public class InvoiceHeader {

    //definition of invoice header data
    String invoiceNum;
    String invoiceDate;
    String customerName;
    ArrayList<InvoiceLine> invoiceLines;

    public InvoiceHeader(String invoiceNum, String invoiceDate, String customerName) {
        this.invoiceNum = invoiceNum;
        this.invoiceDate = invoiceDate;
        this.customerName = customerName;
    }

    public String getInvoiceNum() {
        return invoiceNum;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public ArrayList<InvoiceLine> getInvoiceLines() {
        return invoiceLines;
    }

    public void setInvoiceLines(ArrayList<InvoiceLine> invoiceLines) {
        this.invoiceLines = invoiceLines;
    }
}