package NonDivisibleSubset.com.NonDivisible.DTO;

import Logic.NonDivisible;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class NonDivisibleDTO {

    @Min(1)
    public int k;


    public int[] S;
}
