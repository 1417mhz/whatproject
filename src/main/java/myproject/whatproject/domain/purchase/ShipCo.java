package myproject.whatproject.domain.purchase;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class ShipCo {

    private int companyCode; // auto_increment
    private String name;
    private String contact;

}
