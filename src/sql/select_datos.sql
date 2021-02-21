--MEDICOS
SELECT p.*, m.experiencia, m.trabajos_ant FROM  persona p, medico m WHERE p.ci=m.ci;

--PACIENTES
SELECT p.* FROM  persona p, paciente pac WHERE p.ci=pac.ci;

--USUARIOS
SELECT id, username, creado_en, p.nombre FROM usuario u, medico m, persona p WHERE u.id_medico=m.ci and m.ci=p.ci;

--BUSCAR MEDICOS POR CI
SELECT p.ci, nombre FROM persona p, medico m WHERE m.ci=p.ci AND p.ci LIKE '%4%' ORDER BY nombre;

--CONSULTAS
SELECT * FROM consulta;

SELECT * FROM historial_clinico WHERE id_paciente='983455';