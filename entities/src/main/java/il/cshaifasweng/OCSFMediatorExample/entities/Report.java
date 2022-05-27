package il.cshaifasweng.OCSFMediatorExample.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
@Entity
@Table(name = "Reports")
public class Report implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    private String content;
    private boolean handled=false;
    private  boolean workingOnIT=false;
    private String answer;
    private String reportDate;
    private int MoneyBack;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Shop_id")
    private  Shop shop;


    public Report() {
    }

    public Report(String content, boolean handled, boolean workingOnIT, String answer) {
        this.content = content;
        this.handled = handled;
        this.workingOnIT = workingOnIT;
        this.answer = answer;
        setdate();
    }

    public Report(String content, boolean handled, boolean workingOnIT, String answer, Customer customer) {
        this.content = content;
        this.handled = handled;
        this.workingOnIT = workingOnIT;
        this.answer = answer;
        this.customer = customer;
    }

    public Report(String content, String answer, Customer customer) {
        this.content = content;
        this.answer = answer;
        this.customer = customer;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isHandled() {
        return handled;
    }

    public void setHandled(boolean handled) {
        this.handled = handled;
    }

    public boolean isWorkingOnIT() {
        return workingOnIT;
    }

    public void setWorkingOnIT(boolean workingOnIT) {
        this.workingOnIT = workingOnIT;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getMoneyBack() {
        return MoneyBack;
    }

    public void setMoneyBack(int moneyBack) {
        MoneyBack = moneyBack;
    }

    public void setdate(){
        //Date date=new Date();
        //this.reportDate=date.toString();
        String timeStamp = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
        this.reportDate=timeStamp;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Date getdate(){
        Date date = new Date(this.reportDate)  ;
        return date;
    }


}