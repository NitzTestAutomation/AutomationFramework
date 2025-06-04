package pojo.productsModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;

@JsonIgnoreProperties({"total","limit","skip"})
@Data
public class AllProducts {
    private ArrayList<Products> products ;
}
