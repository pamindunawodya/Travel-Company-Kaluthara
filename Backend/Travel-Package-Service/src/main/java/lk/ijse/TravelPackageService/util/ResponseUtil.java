package lk.ijse.TravelPackageService.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ResponseUtil {

    private String code;

    private String message;

    private Object data;


}
