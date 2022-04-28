package packag;


import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Persona extends Thread{

    public int plantaDestino;
    public int plantaActual;
    public int tiempoPlanta;
    public double id;
    File file = new File("C:\\Users\\anton\\eclipse-workspace\\Ascensores\\src\\packag\\file");
    
    Scanner sc = new Scanner(System.in);
    public Persona(){
        this.plantaDestino=(int) Math.floor(Math.random()*(3-1)+1);
        this.plantaActual=0; 
        double nam = Math.floor(Math.random() * (30 - 15)) + 15;
        this.tiempoPlanta = (int) nam;
        this.id=Math.random();
    }
    
    public void run() {
    	this.plantaDestino = 0;
        
        System.out.println("Hola soy"+this.id+"y voy a la planta: "+this.plantaDestino+" a estar: "+this.tiempoPlanta);
        esperar(1);
       /* añadirPlanta(0,file);
        esperar(1);
        eliminarPlanta(0,file);
        esperar(1);
        añadirPlanta(this.plantaDestino,file);
        esperar(this.tiempoPlanta);
        eliminarPlanta(this.plantaDestino,file);
        esperar(1);
        añadirPlanta(0,file);
        esperar(1);
        eliminarPlanta(0,file);*/
    	añadirPlanta(this.plantaDestino,file);
    	System.out.println("numero sumado");
    	esperar(this.tiempoPlanta);
    	eliminarPlanta(0,file);
        System.out.println("soy "+this.id+"adios");
    }
    
    public void añadirPlanta(int p,File file) {
        try {
            RandomAccessFile raf = new RandomAccessFile(file,"rw");
            
            if(p==0) {
                String n = raf.readLine();
                  String[] lineSplit= n.split("");
                  String num = lineSplit[8];
                  int numero = Integer.parseInt(num);
                  numero++;
                  String numeronuevo = String.valueOf(numero);
                  raf.seek(8);
                  raf.writeBytes(numeronuevo);
            }else if(p==1) {
                String n =" ";
                for(int i=0;i<4;i++) {
                    n = raf.readLine();
                }
                  String[] lineSplit= n.split("");
                  String num = lineSplit[8];
                  raf.close();
                 
                 int numero = Integer.parseInt(num);
                  numero++;
                  String numeronuevo = String.valueOf(numero);
                  System.out.println("H :"+numeronuevo);
              
                  raf.writeBytes(numeronuevo);
                
            }else if(p==2) {
                String n =" ";
                for(int i=0;i<7;i++) {
                    n = raf.readLine();
                }
                  String[] lineSplit= n.split("");
                  String num = lineSplit[8];
                  System.out.println(num);
                  
                 int numero = Integer.parseInt(num);
                  numero++;
                  String numeronuevo = String.valueOf(numero);
            }else if(p==3) {
                String n =" ";
                for(int i=0;i<10;i++) {
                    n = raf.readLine();
                }
                  String[] lineSplit= n.split("");
                  String num = lineSplit[8];
                  System.out.println(num);
                  
                 int numero = Integer.parseInt(num);
                  numero++;
                  String numeronuevo = String.valueOf(numero);
                
            }else if(p==4) {
                String n =" ";
                for(int i=0;i<13;i++) {
                    n = raf.readLine();
                }
                  String[] lineSplit= n.split("");
                  String num = lineSplit[8];
                  System.out.println(num);
                  
                 int numero = Integer.parseInt(num);
                  numero++;
                  String numeronuevo = String.valueOf(numero);
            }else {
                System.out.println("Error");
            }
            
        
        boolean found = false;
        
        }catch (IOException ioe)
        {
             
            System.out.println(ioe);
        }
        catch (NumberFormatException nef)
        {

            System.out.println(nef);
        }
    }
    
    public void eliminarPlanta(int p,File file) {
        try {
            RandomAccessFile raf = new RandomAccessFile(file,"rw");
            if(p==0) {
                String n = raf.readLine();
                  String[] lineSplit= n.split("");
                  String num = lineSplit[8];
                  int numero = Integer.parseInt(num);
                  numero--;
                  String numeronuevo = String.valueOf(numero);
                  raf.seek(8);
                  raf.writeBytes(numeronuevo);
            }else if(p==1) {
            
                String n =" ";
                for(int i=0;i<4;i++) {
                    n = raf.readLine();
                }
                  String[] lineSplit= n.split("");
                  String num = lineSplit[8];
                  raf.close();
                 
                 int numero = Integer.parseInt(num);
                  numero--;
                  String numeronuevo = String.valueOf(numero);
                  System.out.println("H :"+numeronuevo);
              
                  raf.writeBytes(numeronuevo);
            }else if(p==2) {
            String n =" ";
                for(int i=0;i<7;i++) {
                    n = raf.readLine();
                }
                  String[] lineSplit= n.split("");
                  String num = lineSplit[8];
                  raf.close();
                 
                 int numero = Integer.parseInt(num);
                  numero--;
                  String numeronuevo = String.valueOf(numero);
                  System.out.println("H :"+numeronuevo);
              
                  raf.writeBytes(numeronuevo);
                
            }else if(p==3) {
            
                String n =" ";
                for(int i=0;i<10;i++) {
                    n = raf.readLine();
                }
                  String[] lineSplit= n.split("");
                  String num = lineSplit[8];
                  raf.close();
                 
                 int numero = Integer.parseInt(num);
                  numero--;
                  String numeronuevo = String.valueOf(numero);
                  System.out.println("H :"+numeronuevo);
              
                  raf.writeBytes(numeronuevo);
            }else if(p==4) {
            String n =" ";
                for(int i=0;i<13;i++) {
                    n = raf.readLine();
                }
                  String[] lineSplit= n.split("");
                  String num = lineSplit[8];
                  raf.close();
                 
                 int numero = Integer.parseInt(num);
                  numero--;
                  String numeronuevo = String.valueOf(numero);
                  System.out.println("H :"+numeronuevo);
              
                  raf.writeBytes(numeronuevo);
                
            }else {
                System.out.println("Error");
            }
            
        
        boolean found = false;
        
        }catch (IOException ioe)
        {
             
            System.out.println(ioe);
        }
        catch (NumberFormatException nef)
        {

            System.out.println(nef);
        }
    }
    
    public void esperar (int segundos) {
             try {
             Thread.sleep (segundos*1000);
             } catch (Exception e) {
             // Mensaje en caso de que falle
             }
             }
}






