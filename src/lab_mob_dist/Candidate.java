package lab_mob_dist;

public class Candidate {
    private String id;
    private String name;
    private String politicalParty;
    private int votesNumber;

    public Candidate(String id, String name, String politicalParty) {
        this.id = id;
        this.name = name;
        this.politicalParty = politicalParty;
        this.votesNumber = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoliticalParty() {
        return politicalParty;
    }

    public void setPoliticalParty(String politicalParty) {
        this.politicalParty = politicalParty;
    }

    public int getVotesNumber() { return votesNumber; }

    public void setVotesNumber(int votesNumber) { this.votesNumber = votesNumber; }
}
