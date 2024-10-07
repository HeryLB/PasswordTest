package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.example.JavaTestPassword.SecurityLevel.WEAK;
import static com.example.JavaTestPassword.SecurityLevel.MEDIUM;
import static com.example.JavaTestPassword.SecurityLevel.STRONG;
import static org.junit.jupiter.api.Assertions.*;

public class JavaTestPasswordTest {

    @Test
    @DisplayName("Debe devolver WEAK cuando la contraseña es menor a 8 caracteres")
    public void shouldReturnWeakWhenPasswordIsTooShort() {
        assertEquals(WEAK, JavaTestPassword.assessPassword("1234567"), "El password no corresponde");
    }

    @Test
    @DisplayName("Debe devolver WEAK cuando la contraseña contiene solo letras")
    public void shouldReturnWeakWhenPasswordHasOnlyLetters() {
        assertEquals(WEAK, JavaTestPassword.assessPassword("abcdefgh"), "El password no corresponde");
    }

    @Test
    @DisplayName("Debe devolver MEDIUM cuando la contraseña contiene letras y números")
    public void shouldReturnMediumWhenPasswordHasLettersAndNumbers() {
        assertEquals(MEDIUM, JavaTestPassword.assessPassword("abcd1234"), "El password no corresponde");
    }

    @Test
    @DisplayName("Debe devolver STRONG cuando la contraseña contiene letras, números y símbolos especiales")
    public void shouldReturnStrongWhenPasswordHasLettersNumbersAndSymbols() {
        assertEquals(STRONG, JavaTestPassword.assessPassword("abcd123!"), "El password no corresponde");
    }
}
