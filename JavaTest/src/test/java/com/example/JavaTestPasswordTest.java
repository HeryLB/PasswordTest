package com.example;

import org.junit.jupiter.api.Test;

import static com.example.JavaTestPasswordWithService.SecurityLevel.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class JavaTestPasswordWithServiceTest {

    @Test
    public void testStrongPasswordWithMock() {
        // Crear un mock del servicio PasswordStrengthService
        PasswordStrengthService passwordStrengthServiceMock = mock(PasswordStrengthService.class);

        // Definir comportamiento: suponemos que el servicio dice que la contraseña es fuerte
        when(passwordStrengthServiceMock.isStrongPassword("abcd123!")).thenReturn(true);

        // Inyectar el mock en la clase JavaTestPasswordWithService
        JavaTestPasswordWithService javaTestPassword = new JavaTestPasswordWithService(passwordStrengthServiceMock);

        // Probar que se considera STRONG cuando el mock lo define como fuerte
        assertEquals(STRONG, javaTestPassword.assessPassword("abcd123!"));

        // Verificar que el método isStrongPassword fue llamado una vez con el password correcto
        verify(passwordStrengthServiceMock).isStrongPassword("abcd123!");
    }

    @Test
    public void testMediumPasswordWithMock() {
        // Crear un mock del servicio PasswordStrengthService
        PasswordStrengthService passwordStrengthServiceMock = mock(PasswordStrengthService.class);

        // Definir comportamiento: el servicio dice que no es fuerte
        when(passwordStrengthServiceMock.isStrongPassword("abcd1234")).thenReturn(false);

        // Inyectar el mock en la clase JavaTestPasswordWithService
        JavaTestPasswordWithService javaTestPassword = new JavaTestPasswordWithService(passwordStrengthServiceMock);

        // Probar que se considera MEDIUM cuando el mock dice que no es fuerte
        assertEquals(MEDIUM, javaTestPassword.assessPassword("abcd1234!"));

        // Verificar que isStrongPassword fue llamado con la contraseña correcta
        verify(passwordStrengthServiceMock).isStrongPassword("abcd1234!");
    }
}
