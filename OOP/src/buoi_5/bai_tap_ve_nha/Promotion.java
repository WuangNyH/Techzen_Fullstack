package buoi_5.bai_tap_ve_nha;

import buoi_5.bai_tap_ve_nha.exceptions.InvalidPositiveNumberException;

public interface Promotion {
    void promotion(int ratePromote) throws InvalidPositiveNumberException;
}
