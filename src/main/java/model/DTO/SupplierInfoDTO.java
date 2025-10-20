package model.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SupplierInfoDTO {
    private String supplierId;
    private String name;
    private String compnayName;
    private String address;
    private String city;
    private String province;
    private String postalCode;
    private String phone;
    private String email;
}
