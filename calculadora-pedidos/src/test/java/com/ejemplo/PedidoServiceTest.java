package com.ejemplo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PedidoServiceTest {

    // Instancia del repositorio real (sin mocks)
    DescuentoRepository repo = new DescuentoRepository();

    // Servicio con dependencia inyectada
    PedidoService service = new PedidoService(repo);

    @Test
    void testSinDescuentoYEnvioNormal() {
        double total = service.calcularTotal(100, "", false);
        assertEquals(110.0, total); // 100 + envío normal (10)
    }

    @Test
    void testConDescuentoYEnvioExpress() {
        double total = service.calcularTotal(100, "PROMO10", true);
        assertEquals(110.0, total); // 100 - 10% + envío express (20)
    }

    @Test
    void testConDescuentoYEnvioNormal() {
        double total = service.calcularTotal(200, "PROMO10", false);
        assertEquals(190.0, total); // 200 - 10% + envío normal (10)
    }

    @Test
    void testSinDescuentoYEnvioExpress() {
        double total = service.calcularTotal(150, "", true);
        assertEquals(170.0, total); // 150 + envío express (20)
    }
}
