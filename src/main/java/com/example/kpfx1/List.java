package com.example.kpfx1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


class ListElement {
    ListElement next;    // указатель на следующий элемент
    int data;            // данные
}
public class List {
    private ListElement head;       // указатель на первый элемент
    private ListElement tail;       // указатель последний элемент
    @FXML
    public Button btnA;
    public TextField tf;
    public TextField tf2;
    public TextField tf1;
    public TextField tf11;
    public Label lb;
    public Label lb1;
    public Label lb2;
    public Label lb3;
    public Label lbE;

    public void addBack(int data) {           //добавить c конца
        ListElement a = new ListElement();  //создаём новый элемент
        a.data = data;                      //инициализируем данные
                                            // указатель на следующий элемент автоматически инициализируется как null
        if(head == null){                   //если список пуст, то указываем ссылки начала и конца на новый элемент
            head = a;                       //список теперь состоит из одного элемента
            tail = a;
        } else {
            a.next = head;                  //иначе новый элемент теперь ссылается на бывший первый
            head = a;                       //а указатель на первый элемент теперь ссылается на новый элемент
        }}

    public void addFront(int data) {          //добавление в начало списка
        ListElement a = new ListElement();  //создаём новый элемент
        a.data = data;                      //а в указатель на последний элемент записываем адрес нового элемента
        if (tail == null){                  //если список пуст, то указываем ссылки начала и конца на новый элемент
            head = a;                          // список теперь состоит из одного элемента
        } else {
            tail.next = a;                  //иначе старый последний элемент теперь ссылается на новый
        }
        tail = a;
    }

    public String printList(){                      //печать списка
        StringBuilder str = new StringBuilder();
        ListElement t = this.head;                  //получаем ссылку на первый элемент
        while (t != null) {                         //пока элемент существует
            str.append(t.data).append(" ");         //печатаем его данные
            t = t.next;                             //и переключаемся на следующий
        }
        return str.toString();
    }


    public void addAfter(int prevEl, int nextEl){       //добавление в список
        ListElement t = this.head;                      //Получаем ссылку на первый элемент
        while (t!=null){                                //ищем элемент, после которого нужно добавить
            if(prevEl==t.data){                         // если это он, то после него вставляем элемент
                ListElement e = new ListElement();
                e.data = nextEl;
                e.next = t.next;
                t.next = e;
                t = e;
            }
            t = t.next;
        }}

    public void delEl(int data){            //удаление элемента
        if(head == null)                     //если список пуст
            return;                         //ничего не делаем
        else if (head == tail) {            //если список состоит из одного элемента
            head = null;                    //очищаем указатели начала и конца
            tail = null;
            return;
        }
        else if (head.data == data) {       //если первый элемент тот что нам нужен
            head = head.next;               //переключаем указатель начала на второй элемент
            return;
        }
        else {
            ListElement t = head;           //иначе начинаем искать
            while (t.next != null) {        //пока следующий элемент существует
                if (t.next.data == data) {  //проверяем следующий элемент
                    if(tail == t.next)      //если он последний
                    {
                        tail = t;           //то переключаем указатель на последний элемент на текущий
                    }
                    t.next = t.next.next;   //найденный элемент выкидываем
                    return;
                }
                t = t.next;                //иначе ищем дальше
            }}}

    @FXML
    protected void main() {
        btnA.setOnAction(event -> {
            List l = new List();
            List k = new List();
            try {
                int n = Integer.parseInt(tf.getText());
                for(int i = 0; i<=n; i++){
                    l.addFront(i);}
                for(int i = 0; i<=n; i++){
                    k.addBack(i);}
                lb.setText(l.printList());
                lb2.setText(k.printList());
                l.addAfter(Integer.parseInt(tf1.getText()), Integer.parseInt(tf11.getText()));
                k.addAfter(Integer.parseInt(tf1.getText()), Integer.parseInt(tf11.getText()));
                l.delEl(Integer.parseInt(tf2.getText()));
                k.delEl(Integer.parseInt(tf2.getText()));
                lb1.setText(l.printList());
                lb3.setText(k.printList());
            } catch (Exception e) {
                lbE.setText("Ошибка! Проверьте, все ли поля заполнены. В поля вводите только целочисленные значения.");
            }
        });}}
