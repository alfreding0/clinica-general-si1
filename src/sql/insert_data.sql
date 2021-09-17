--MEDICO
INSERT INTO persona (ci, nombre, celular, email, fecha_nac, genero, direccion, ocupacion) VALUES ('862834', 'Alfredo Gonzales Quiucha', '234244',	'alf@gmail.com', '27/7/2000', 'M', 'calle 23', 'Medico cirujano');
INSERT INTO medico (ci, experiencia, trabajos_ant) VALUES ('862834', 'ninguna', 'ninguna');		




--PACIENTE
insert into persona (ci, nombre, celular, email, fecha_nac, genero, direccion, ocupacion)
	values ('983455', 'Lolita lalita', '234345', 'lolita@gmail.com', '19/4/92', 'F', 'calle 21', 'Medico digestivo');
insert into paciente (ci) values ('983455');



INSERT INTO usuario (username, password, privilegio, id_medico) VALUES ('alfreding0', md5('alfreding0'), 'A', '862834');

UPDATE historial_clinico SET epilepsia_convulciones = true, 
							epilepsia_convulciones_tratamiento = 'ninguno', 
							anemia = false, 
							anemia_tratamiento = null, 
							diabetes = false, 
							diabetes_tratamiento = null, 
							hepatitis = true, 
							hepatitis_tratamiento = 'nose sabe', 
							hipertension_arterial = true, 
							hipertension_arterial_tratamiento = 'nada de nada', 
							asma = false, 
							asma_tratamiento = null, 
							tuberculosis = false, 
							tuberculosis_tratamiento = null, 
							vih_sida = false, 
							vih_sida_tratamiento = null, 
							gastritis = true, 
							gastritis_tratamiento = 'no sabo', 
							cancer = false, 
							cancer_tratamiento = null, 
							menopausia = true 
							WHERE id_paciente = '983455';
									 

INSERT INTO consulta (razon_motivo, hora_ini, hora_fin, precio, id_paciente, id_medico) 
			VALUES ('sin motivos', '12:34', '13:38', '130.23', '983455', '862834');



INSERT INTO tratamiento (duracion_dias, descripcion, costo, id_paciente, id_medico) 
VALUES ('12', 'limpieza total', '34.58', '983455', '862834');