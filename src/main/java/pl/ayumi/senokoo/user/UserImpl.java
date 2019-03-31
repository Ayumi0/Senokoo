package pl.ayumi.senokoo.user;

public class UserImpl implements User {
    private String id;
    private Rank rank;
    private Integer money;

    public UserImpl(String id, Rank rank, Integer money) {
        this.id = id;
        this.rank = rank;
        this.money = money;
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public Rank getRank() {
        return rank;
    }

    @Override
    public Integer getMoney() {
        return money;
    }

    @Override
    public void setRank(Rank rank) {

        this.rank = rank;
    }

    @Override
    public void setMoney(Integer money) {

        this.money = money;
    }
}
