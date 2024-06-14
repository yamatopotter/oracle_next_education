package org.example.templateMethod.solucao;

import org.example.templateMethod.VeiculoParaReparo;

public abstract class ReparoVeiculoService {
    public void reparaVeiculo(){
        entradaOficina();
        analisarDanos();

        if(veiculoParaReparo()){
            repararVeiculo();
            notificarReparoParaSeguradora();
        }
        else{
            notificarPerdaTotalParaSeguradora();
        }
    }
//O método abstrato obriga a herdeira a implementar a função com a particularidade desejada
    protected abstract boolean veiculoParaReparo();

    private void notificarPerdaTotalParaSeguradora() {
        System.out.println("Notificando perda total para seguradora...");
    }

    private void repararVeiculo() {
        System.out.println("Reparando veiculo...");
    }

    private void notificarReparoParaSeguradora() {
        System.out.println("Notificando reparos para seguradora...");
    }

    private void analisarDanos() {
        System.out.println("Analisando danos...");
    }

//    Protected permite a herdeira fazer a reescrita
    protected void entradaOficina() {
        System.out.println("Veículo entrando na oficina...");
    }
}
