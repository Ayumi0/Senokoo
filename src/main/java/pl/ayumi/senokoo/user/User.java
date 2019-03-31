package pl.ayumi.senokoo.user;

public interface User {
    String getID();

    Rank getRank();

    Integer getMoney();

    void setRank(Rank rank);

    void setMoney(Integer money);
}
