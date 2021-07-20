package br.com.jgs.aula03;

public class ThreadExemplo {

    public static void main(String[] args) {
        BarraDeCarregamentoThread();
        try {
            Thread.sleep(5000);
            GerarPdfThread();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void BarraDeCarregamentoThread(){
        Thread thread = new Thread(new BarraDeCarregamento2());
        Thread thread2 = new Thread(new BarraDeCarregamento3());

        thread.start();
        thread2.start();

        System.out.println("Nome da thread: " + thread.getName());
        System.out.println("Nome da thread: " + thread2.getName());
    }

    public static void GerarPdfThread(){
        GerardorPDF iniciarGerarPdf = new GerardorPDF();
        BarraDeCarregamento iniciarBarraDeCarregamento = new BarraDeCarregamento(iniciarGerarPdf);

        iniciarGerarPdf.start();
        iniciarBarraDeCarregamento.start();
    }

}

class GerardorPDF extends Thread{
    @Override
    public void run(){
        try {
            System.out.println("Iniciar geração de PDF");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("PDF Gerado");
    }
}

class BarraDeCarregamento extends Thread{
    private Thread iniciarGeradorPdf;

    public BarraDeCarregamento(Thread iniciarGeradorPdf){
        this.iniciarGeradorPdf = iniciarGeradorPdf;
    }

    @Override
    public void run(){
        while (true){
            try {
                Thread.sleep(500);
                if (!iniciarGeradorPdf.isAlive()){
                    break;
                }
                System.out.println("Loading...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class BarraDeCarregamento2 implements Runnable{
    @Override
    public void run(){
        try {
            Thread.sleep(3000);
            System.out.println("Rodou BarraDeCarregamento2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class BarraDeCarregamento3 implements Runnable{
    @Override
    public void run(){
        try {
            Thread.sleep(1000);
            System.out.println("Rodou BarraDeCarregamento3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
