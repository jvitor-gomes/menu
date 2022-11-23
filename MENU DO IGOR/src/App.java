import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);

        String[] nomesProd = new String[100];
        double[] precosProd = new double[nomesProd.length];
        String[] nomesEncontrados = new String[nomesProd.length];
        double[] precosEncontrados = new double[nomesProd.length];
        String[] nomesRemov = new String[nomesProd.length];
        double[] precosRemov = new double[nomesProd.length];

        String escolha = "";
        int IndProd = 0;

        while (!escolha.equals("5")) {

            System.out.println("-----------------------");
            System.out.println("      MENU");
            System.out.println("-----------------------");
            System.out.println(" 1 - Adicionar produto ");
            System.out.println(" 2 - Buscar produto ");
            System.out.println(" 3 - Mostrar Produtos ");
            System.out.println(" 4 - Remover um Produto ");
            System.out.println(" 5 - Fechar sistema ");
            System.out.println("-----------------------");

            System.out.print(" OPÇÃO: ");
            escolha = in.next();

            if (escolha.equals("4")) {
                System.out.print(" Qual produto gostaria de remover: ");
                    int IndRemovProd = in.nextInt();
                    IndRemovProd--;
                    System.out.println("Produto removido: "+nomesProd[IndRemovProd]+" - "+precosProd[IndRemovProd]);

                    if (IndRemovProd == 0 || IndRemovProd < nomesProd.length) {
                        for(int i = IndRemovProd; i < nomesProd.length; i++){
                            if (i == nomesProd.length-1) {
                                nomesProd[i] = null;
                                precosProd[i] = -1;
                            } else if(IndRemovProd <= nomesProd.length){
                                nomesProd[i] = nomesProd[i+1];
                                precosProd[i] = precosProd[i+1];
                            }
                            }
                    }
                    
                        
                    
                    
            } else if (escolha.equals("1")) {
                System.out.print("Digite o nome do produto: ");
                    nomesProd[IndProd] = in.next();

                    System.out.print("Digite o valor do produto: R$ ");
                    precosProd[IndProd] = in.nextDouble();

                    IndProd++;
            } else if (escolha.equals("2")) {
                int qtdeProdEnc = 0;
                    System.out.println("Faca sua busca:");
                    String nomeDigitado = in.next();
                    for (int cont = 0; cont < nomesProd.length; cont++) {
                        if (nomesProd[cont] != null && nomesProd[cont].toUpperCase().contains(nomeDigitado.toUpperCase())) {
                            nomesEncontrados[qtdeProdEnc] = nomesProd[cont];
                            precosEncontrados[qtdeProdEnc] = precosProd[cont];
                            qtdeProdEnc++;
                        }
                    }
                    if(qtdeProdEnc > 0) {
                        System.out.println("Produtos encontrados:");
                        for(int j = 0; j<qtdeProdEnc; j++) {
                            System.out.println("Nome: "+nomesEncontrados[j]);
                            System.out.println("Preco: R$ "+precosEncontrados[j]);
                            System.out.println("---------------------------------");
                        }
                    } else {
                        System.out.println("Nenhum produto encontrado!");
                    }
                } else if (escolha.equals("3")) {
                for(int contProd = 0; contProd < nomesEncontrados.length; contProd++ ){
                    if (nomesProd[contProd] != null) {
                
                    System.out.println("["+(contProd + 1)+"]"+" - "+nomesProd[contProd]+": R$ "+precosProd[contProd]);
                }
                }
            } else if (escolha.equals("5")) {
                System.out.println("Programa encerrado...");
                break;
            } else {
                System.out.println("DIGITE UMA OPÇÃO VÁLIDA");
            }

        System.out.println(nomesProd[0]);
        }

        in.close();

    }
}