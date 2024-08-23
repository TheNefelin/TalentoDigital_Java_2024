
-- Algo esta Raro en las ventas
SELECT
    a.Nombre AS Camarero,
    b.Total AS Vetas_Totales,
    SUM(c.Subtotal)AS Validar_Ventas
FROM camarero a
         INNER JOIN pedido b ON b.Camarero_ID = a.ID
         INNER JOIN detalle_pedido c ON c.Pedido_ID = b.ID
GROUP BY
    a.Nombre,
    b.Total
ORDER BY
    SUM(c.Subtotal) ASC;


SELECT * FROM camarero WHERE Id = 2;
SELECT * FROM pedido WHERE Camarero_ID = 2;
SELECT * FROM detalle_pedido WHERE Pedido_ID = 3;
SELECT * FROM plato WHERE ID = 1 OR id = 3;

