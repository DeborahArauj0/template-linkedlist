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

        if (isEmpty()) throw new RuntimeException("LinkedList vazia");
        
        return this.head.value;
    }

    public int getLast() {
        if (isEmpty()) throw new RuntimeException("LinkedList vazia");
        
        return this.tail.value;
    }

    // retorna o elemento na posição  passada como parâmetro
    // deve lançar IndexOutOfBoundsException se o índice não for válido.
    public int get(int index) {

        if (index < 0 || index >= this.size) throw new IndexOutOfBoundsException();
        
        Node aux = this.head;

        int i = 0;
        while (i < index) {
            aux = aux.next;
            i++;
        }

        return aux.value;
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

        if (index < 0 || index >= this.size) throw new IndexOutOfBoundsException();
        //for até esse índice usando aux como cada passo
        //se for o primeiro elemento 
        if(index == 0) removeFirst();
        //último elemento
        if(index == size - 1) removeLast();

        Node aux = this.head;

        for (int i = 0; i < index; i++)
            aux = aux.next;

        aux.prev.next = aux.next;
        aux.next.prev = aux.next;
        this.size--;
        //mais de dois elementos
        return aux.value;
    }

    // remove a primeira ocorrência do elemento cujo valor foi passado como parâmetro.
    // se não encontrar, não faça nada. true se remover, false se não remover.
    public boolean removeByValue(int value) {

        if (isEmpty()) return false;

        Node aux = this.head;

        for (int i = 0; i < this.size; i++) {
            if(value == aux.value) {
                if (i == 0) {
                    removeFirst();
                } else if(i == this.size){
                    removeLast();
                } else {
                    aux.next = aux.next.next;
                    aux.next.prev = aux;
                    this.size--;
                }
                return true;
            }

            aux = aux.next;
        }

        return false; //caso não encontre o valor 

    }

    // retorna a posição da primeira ocorrência do valor passado como parâmetro.
    public int indexOf(int value) {

        if (isEmpty()) return -1;

        int posi = 0;

        Node aux = this.head;

        while (aux != null){

            if (aux.value == value) {
                return posi;
            }

            aux = aux.next;
            posi++;
        }
        //caso chegue ao fim e não encontre o elemento
        return -1;
    }

    public boolean contain(int v) {

        if(!isEmpty()) {

            Node aux = this.head;

            while(aux != null){
                
                if (aux.value == v) return true; 

                aux = aux.next;

            }
        }

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

    //Esse método move o elemento que está em index para a cabeça da fila. Ele é O(n) para procurar o elemento,
    //mas para mover, você deve fazer em O(1), ou seja, apenas manipulando referências.
    public void moveToHead(int index) {
        //verfica se index é válido
        if (index < 0 || index >= this.size) throw new IndexOutOfBoundsException();

        Node aux = this.head;
        //acessa em O(n) o elemento que está no índice
        for (int i = 0; i < index; i++) {
            aux = aux.next;
        }

        if (index == 0) return; //possui apenas um elemento ou ele já é a cabeçao. Não faz alteração nenhuma
        //esse é o último elemento
        if (aux == tail) { 

            this.tail = aux.prev;
            this.tail.next = null;

        } else {
            aux.prev.next = aux.next; 
            aux.next.prev = aux.prev;

        }
        
        //após remover o elemento da posição index da lista, adiciona na cabeça da fila
        aux.next = this.head;
        aux.prev = null;
        this.head.prev = aux;
        this.head = aux;
      
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