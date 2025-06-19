package com.ejemplo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PedidoServiceMockTest {

    @Test
    void testConMockDeDescuento() {
        // Crear mock del repositorio
        DescuentoRepository mockRepo = mock(DescuentoRepository.class);
        when(mockRepo.obtenerPorcentaje("PROMO10")).thenReturn(0.10);

        // Inyectar mock en el servicio
        PedidoService service = new PedidoService(mockRepo);

        // Ejecutar método y verificar resultado
        double total = service.calcularTotal(100, "PROMO10", true);
        assertEquals(110.0, total); // 100 - 10% + 20
    }
}
