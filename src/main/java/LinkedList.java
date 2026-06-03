import java.util.NoSuchElementException;

public class LinkedList {

    private Node head;
    private Node tail;
    private int size;
    
    public LinkedList() {

       this.tail = null;
       this.head = null;
       this.size = 0; //quantidade de elementos na linkedlist

    }
   
    public boolean isEmpty() {

        return this.head == null;
    }

    public void addFirst(int valor) {

        Node newNode = new Node(valor);
        //linkdlist vazia
        if (isEmpty()){
            this.head = newNode;
            this.tail = newNode;

        } else {

            newNode.next = this.head;
            newNode.prev = null;
            this.head.prev = newNode; //altera o antecessor da cabeça de null para nova cabeça
            this.head = newNode;
        }
        this.size++;

    }

    public void addLast(int valor) {

        Node newNode = new Node(valor);

        if(isEmpty()){

            this.head = newNode;
            this.tail = newNode;
        
        } else {

            newNode.prev = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        }

        size++;
    }

    // adiciona um valor na posição passada como parâmetro
    public void add(int index, int valor) {
    }

    public int getFirst() {
        return -1;
    }

    public int getLast() {
        return -1;
    }

    // retorna o elemento na posição  passada como parâmetro
    // deve lançar IndexOutOfBoundsException se o índice não for válido.
    public int get(int index) {
         return -1;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeFirst() {

        
        //muda os ponteiros do primeiro
        if (isEmpty()) throw new RuntimeException("LinkedList vazia");
        
        int noRemovido = this.head.value; 
        //se houver apenas um elemento, tail também recebe alterações
        if (this.size == 1){
            this.head = null;
            this.tail = null;

        } else {

            this.head.next.prev = null; //a direita da cabeça passa a receber null como antecessor
            this.head = this.head.next; //a nova cabeça é direita da antiga cabeça
        }

        this.size--;
        return noRemovido;
    }

    // deve lançar exceção caso a fila esteja vazia.
    public int removeLast() {

        if (isEmpty()) throw new RuntimeException("LinkedList vazia");
        //muda os ponteiros do ultimo
        int noRemovido = this.tail.value;

        if (this.size == 1) {
            
            this.head = null;
            this.tail = null;
        
        } else {
         
            this.tail = this.tail.prev;
            this.tail.next = null;  
            
        }
        this.size--;
        return noRemovido;
    }

    // remove o valor no índice passado como parâmetro. retorna o valor removido.
    // lançar exceção se o índice não for válido.
    public int remove(int index) {

        //for até esse indice usando aux como cada passo
        return -1;
    }

    // remove a primeira ocorrência do elemento cujo valor foi passado como parâmetro.
    // se não encontrar, não faça nada. true se remover, false se não remover.
    public boolean removeByValue(int value) {
        return false;
    }

    // retorna a posição da primeira ocorrência do valor passado como parâmetro.
    public int indexOf(int value) {
        return -1;
    }

    public boolean contain(int v) {
        return false;
    }
   
    // Deve retornar a posição da última ocorrência do elemento passado como parâmetro. 
    public int lastIndexOf(int valor) {

        if (isEmpty()) return -1;

        int posi = this.size -1; //indica o índice onde o nó se encontra

        Node aux = this.tail; //como é a última ocorrência, inicia do final

        while (aux != null){

            if (aux.value == valor){
                return posi;
            }

            aux = aux.prev;
            posi--;

        }

        //se chegar ao fim e não encontrar
        return -1;
    }
    
    // deve retornar uma string representando a lista. 
    public String toString() {
        if (isEmpty()) return "";

        Node aux = this.head;
        String out = "";
        while (aux != null) {
            out += aux.value + ", ";
            aux = aux.next;
        }
        return out.substring(0, out.length() - 2);
    }
    
    public int size() {
        return this.size;
    }
}

class Node {

    int value;
    Node prev;
    Node next;

    Node(int v) {
        this.value = v;
    }

}