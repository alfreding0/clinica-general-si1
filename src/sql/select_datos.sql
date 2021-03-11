--MEDICOS
SELECT p.*, m.experiencia, m.trabajos_ant FROM  persona p, medico m WHERE p.ci=m.ci AND p.ci='';

--PACIENTES
SELECT p.* FROM  persona p, paciente pac WHERE p.ci=pac.ci;

--USUARIOS
SELECT id, username, creado_en, p.nombre FROM usuario u, medico m, persona p WHERE u.id_medico=m.ci and m.ci=p.ci;

--BUSCAR MEDICOS POR CI
SELECT p.ci, nombre FROM persona p, medico m WHERE m.ci=p.ci AND p.ci LIKE '%4%' ORDER BY nombre;

SELECT * FROM historial_clinico WHERE id_paciente='983455';







--CONSULTAS ===================================================================
--(para mostrar todas las columnas excepto el de medico)
SELECT c.id, per.nombre as paciente, c.razon_motivo, c.fecha, c.hora_ini, c.hora_fin, c.precio
FROM consulta c, paciente p, persona per
WHERE c.id_paciente=p.ci AND per.ci=p.ci
AND c.fecha BETWEEN '10/3/21' AND '11/3/21'
ORDER BY c.id;

--(para mostrar solo medico)
SELECT c.id, per.nombre as medico
FROM consulta c, medico m, persona per
WHERE c.id_medico=m.ci AND per.ci=m.ci
AND c.fecha BETWEEN '10-3-21' AND '11-3-21'
ORDER BY c.id;
