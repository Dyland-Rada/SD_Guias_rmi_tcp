/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dylandrada.seminario.imc.net;
import dylandrada.imc.rmi.lib.IRemotaCalculoImc;
import java.io.IOException;
import net.sf.lipermi.exception.LipeRMIException;
import net.sf.lipermi.handler.CallHandler;
import net.sf.lipermi.net.Server;

/**
 *
 * @author Dyland Rada
 */
public class Servidor {

    private int puerto = 9007;
    private CallHandler invocador;
    private Server servidor;
    private CalculoRmiImcImplement calculoImc;
    private IRemotaCalculoImc calculoImcRemoto;

    public Servidor() {
        invocador = new CallHandler();
        servidor = new Server();
        calculoImc = new CalculoRmiImcImplement();
    }

    public void iniciar() throws Exception {
        try {
                
            System.out.println(puerto);
            System.out.println(calculoImc);
            
            
            invocador.registerGlobal(IRemotaCalculoImc.class, calculoImc);
            servidor.bind(puerto, invocador);
            System.out.println(calculoImcRemoto);
        } catch (LipeRMIException ex) {
            throw new Exception("Error: No es posible invocar metodos remotos");
        } catch (IOException ex) {
            throw new Exception("Error: I/0");
        }
    }

    public void detener() {
        servidor.close();
    }
}

