
SELECT
    a.inventario_nombre,
    a.inventario_marca,
    b.tipo_producto_descripcion
FROM inventario a
    INNER JOIN tipo_producto b ON a.tipo_producto_id = b.tipo_producto_id
    INNER JOIN sucursal c ON c.sucursal_id = a.sucursal_id;