import java.util.ArrayList;
import java.util.Scanner;

abstract class Animale {

    private String nomeAnimale;
    private int eta;
    private String specie;
    private String proprietario;

    public Animale(String nomeAnimale, int eta, String specie) {
        this.nomeAnimale = nomeAnimale;
        this.eta = eta;
        this.specie = specie;
        this.proprietario = "";
    }

    public void setProprietario(String proprietario){
        this.proprietario = proprietario;
    }

    public String getNomeAnimale() {
        return nomeAnimale;
    }

    public void setNomeAnimale(String nomeAnimale) {
        this.nomeAnimale = nomeAnimale;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }
    public String getPropritario() {
        return proprietario;
    }

    public void setPropritario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getDescrizione() {
        return "Nome: " + nomeAnimale + ", Età: " + eta + ", Specie: " + specie;
    }
}

class Cane extends Animale {

    private String razza;
    private String microchipId;
    private Personale persona;

    public Cane(String nomeAnimale, int eta, String specie, String proprietario, String razza, String microchipId) {
        super(nomeAnimale, eta, specie);
        this.razza = razza;
        this.microchipId = microchipId;
        this.persona = null;
    }

    public String getRazza() {
        return razza;
    }

    public void setPersonale(Personale persona){
        this.persona = persona;
    }

    public void setRazza(String razza) {
        this.razza = razza;
    }

    public String getMicrochipId() {
        return microchipId;
    }

    public void setMicrochipId(String microchipId) {
        this.microchipId = microchipId;
    }

    public String getDescrizione_completa() {
        return super.getDescrizione()+", Razza: " + razza + ", Microchip ID:" + microchipId;
    }

    public String getDescrizione_completaAdott() {
        return super.getDescrizione()+", Razza: " + razza + ", Microchip ID:" + microchipId + ", Proprietario: " + this.getPropritario() + ", Adozione gestita da: " + this.persona.getNome();
    }

}

class Personale {
    String nome;
    String ruolo;

    public Personale(String nome, String ruolo) {
        this.nome = nome;
        this.ruolo = ruolo;
    }

    public String info_personale() {
        return "Nome: " + nome + ", Ruolo: " + ruolo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public String getNome() {
        return nome;
    }

    public String getRuolo() {
        return ruolo;
    }

}

public class Canile {

    public static void main(String[] args) {

        ArrayList<Cane> cani = new ArrayList<>();
        ArrayList<Cane> caniAdottati = new ArrayList<>();
        ArrayList<Personale> dipendenti = new ArrayList<>();


        Scanner myObjN = new Scanner(System.in);
        Scanner myObjS = new Scanner(System.in);

        // Creare istanze di Personale
        Personale cristian = new Personale("Cristian", "Dottore");
        Personale gilberto = new Personale("Gilberto", "Spala-Merda");
        Personale alessia = new Personale("Alessia", "Consulente Terapeutica");

        dipendenti.add(cristian);
        dipendenti.add(gilberto);
        dipendenti.add(alessia);

        Cane samantha = new Cane("Samantha", 13, "Cane","", "Pitbull", "54795289");
        Cane oreo = new Cane("Oreo", 2, "Cane","", "Meticcio", "15184648");
        Cane bobby = new Cane("Bobby", 8, "Cane","", "Labrador", "16198254");

        cani.add(oreo);
        cani.add(samantha);
        cani.add(bobby);

        System.out.print("Inserire il tuo nome per LOGGARE: ");
        String utente = myObjS.nextLine();

        Personale user = null;

        boolean j = false;

        for (Personale persona : dipendenti) {
            if (utente.equalsIgnoreCase(persona.getNome())){
                System.out.println("Hai loggato con successo");
                user = persona;
                j = true;
            }
        }

        while (j){

            System.out.println("Che azione vuoi compiere?");
            System.out.println("1- visualizza cani in canile");
            System.out.println("2- visualizza cani adottati");
            System.out.println("3- aggiungi cane al canile");
            System.out.println("4- fai adottare un cane");
            System.out.println("5- esci");
            int op = myObjN.nextInt();

            switch(op){
                case 1: 
                    System.out.println("Elenco dei cani pronti all'adozione:");
                    for (Cane cane : cani) {
                        System.out.println(cane.getDescrizione_completa());
                    }
                    break;
                case 2:
                    System.out.println("Elenco dei cani adottati:");
                    for (Cane cane : caniAdottati) {
                        System.out.println(cane.getDescrizione_completaAdott());
                    }
                    break;
                case 3:
                    System.out.print("Inserisci il nome del cane: ");
                    String nomeCaneNuovo = myObjS.nextLine();
                    System.out.print("Inserisci l'età del cane: ");
                    int etaCaneNuovo = myObjN.nextInt();
                    System.out.print("Inserisci la razza: ");
                    String razzaCaneNuovo = myObjS.nextLine();
                    System.out.print("Inserisci il codice del microchip: ");
                    String microNuovoCane = myObjS.nextLine();

                    Cane nuovoCane = new Cane(nomeCaneNuovo, etaCaneNuovo, "Cane", "", razzaCaneNuovo, microNuovoCane);

                    cani.add(nuovoCane);

                    break;
                case 4: 
                    System.out.print("Inserire nome della persona che vuole adottare: ");
                    String adottante = myObjS.nextLine();

                    System.out.println("Elenco dei cani pronti all'adozione:");
                    for (Cane cane : cani) {
                        System.out.println(cane.getDescrizione_completa());
                    }

                    System.out.print("Inserisci il nome del cane da adottare: ");
                    String nomeCaneAdotto = myObjS.nextLine();

                    int i = 0;

                    Cane oggetto = null;

                    for (Cane cane : cani) {
                        if(nomeCaneAdotto.equalsIgnoreCase(cane.getNomeAnimale())){
                            cane.setPropritario(adottante);
                            i++;
                            System.out.println(cane.getPropritario() + " ha adottato il cane dal nome " + cane.getNomeAnimale());
                            cane.setPersonale(user);
                            caniAdottati.add(cane);
                            oggetto = cane;
                        }
                    }

                    if (i == 0){
                        System.out.println("Cane non presente");
                    } else {
                        cani.remove(oggetto);
                    }
                    break;
                case 5: 
                    System.out.println("Grazie di aver usato il programma");
                    j = false;
                    break;       

            }


        }

    }

}
