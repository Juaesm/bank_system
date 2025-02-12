import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Client extends Person{
    Client(String name, String last_name, String id)
    {
        super(name, last_name, id);
    }


}
