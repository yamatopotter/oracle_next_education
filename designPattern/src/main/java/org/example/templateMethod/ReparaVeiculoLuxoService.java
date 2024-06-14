package org.example.templateMethod;

public class ReparaVeiculoLuxoService {
    private VeiculoParaReparo veiculoParaReparo;

    public ReparaVeiculoLuxoService(VeiculoParaReparo veiculoParaReparo){
        this.veiculoParaReparo = veiculoParaReparo;
    }

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

    private boolean veiculoParaReparo(){
        return veiculoParaReparo.getPorcentagemDano() <= 50;
    }

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

    private void entradaOficina() {
        System.out.println("Veículo entrando na oficina...");
    }


}
