package org.akavity.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FiltersData {
    String productName;
    String minPrice;
    String maxPrice;
    String filterName;
    String item;
    String label;
}
