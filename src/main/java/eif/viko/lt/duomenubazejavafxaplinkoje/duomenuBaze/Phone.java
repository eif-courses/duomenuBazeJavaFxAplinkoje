package eif.viko.lt.duomenubazejavafxaplinkoje.duomenuBaze;

public class Phone {
    private Integer id;
    private String name;
    private int amount_of_ram;

    public Phone(Integer id, String name, int amount_of_ram) {
        this.id = id;
        this.name = name;
        this.amount_of_ram = amount_of_ram;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount_of_ram() {
        return amount_of_ram;
    }

    public void setAmount_of_ram(int amount_of_ram) {
        this.amount_of_ram = amount_of_ram;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount_of_ram=" + amount_of_ram +
                '}';
    }
}
