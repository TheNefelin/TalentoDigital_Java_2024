
-- Algo no Cuadra
SELECT
    a.ID AS Id_Pedido,
    b.Numero AS Mes,
    c.Nombre AS Camarero,
    a.Total,
    SUM(d.Subtotal) AS total_detalle,
    SUM(e.Precio) AS total_plato
FROM pedido a
         INNER JOIN mesa b ON b.ID = a.Mesa_ID
         INNER JOIN camarero c ON c.ID = a.Camarero_ID
         INNER JOIN detalle_pedido d ON d.Plato_ID = a.ID
         INNER JOIN plato e ON e.ID = d.Plato_ID
GROUP BY
    a.ID,
    b.Numero,
    c.Nombre,
    a.Total;