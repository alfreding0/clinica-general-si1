/* create database db_clinica_general*/
create table persona(
	ci varchar(12) primary key,
    nombre varchar(50) not null,
    celular varchar(10) not null,
    email varchar(50),
    fecha_nac date not null,
    genero varchar(1) not null,
    direccion varchar(100) not null,
    ocupacion varchar(150) not null,
    fecha_reg timestamp default now()
);

create table medico(
    ci varchar(12) primary key,
    experiencia varchar(100) not null,
    trabajos_ant varchar(150) not null,
    foreign key (ci) references persona(ci)
	on update cascade on delete cascade
);

create table paciente(
	ci varchar(12) primary key,
    foreign key (ci) references persona(ci)
	on update cascade on delete cascade
);

create table usuario(
	id serial primary key,
	username varchar(20) not null,
	password varchar(50) not null,
	creado_en timestamp  default current_timestamp,
	id_medico varchar(12) not null,
	foreign key (id_medico) references medico (ci)
	on update cascade on delete cascade
);

create table historial_clinico(
	id serial primary key,
	epilepsia_convulciones bool default 'false',
	epilepsia_convulciones_tratamiento text,
	anemia bool default 'false',
	anemia_tratamiento text,
	diabetes bool default 'false',
	diabetes_tratamiento text,
	hepatitis bool default 'false',
	hepatitis_tratamiento text,
	hipertension_arterial bool default 'false',
	hipertension_arterial_tratamiento text,
	asma bool default 'false',
	asma_tratamiento text,
	tuberculosis bool default 'false',
	tuberculosis_tratamiento text,
	vih_sida bool default 'false',
	vih_sida_tratamiento text,
	gastritis bool default 'false',
	gastritis_tratamiento text,
	cancer bool default 'false',
	cancer_tratamiento text,
	menopausia bool default 'false',
	id_paciente varchar(12) not null unique,
	foreign key (id_paciente) references paciente (ci)
	on update cascade on delete cascade
);

create table consulta(
	id serial primary key,
	razon_motivo text not null,
	fecha date default now(),
	hora_ini time default now(),
	hora_fin time default now(),
	precio float(2) not null,
	id_paciente varchar(12) not null, 
	id_medico varchar(12) not null, 
	foreign key (id_paciente) references paciente (ci),
	foreign key (id_medico) references medico (ci)
	on update cascade on delete cascade
);

create table tratamiento(
	id serial primary key,
	duracion_dias int not null,
	descripcion text not null,
	costo float(2) not null,
        pagado float(2) default 0.0,
	id_paciente varchar(12) not null, foreign key (id_paciente) references paciente (ci),
	id_medico varchar(12) not null, foreign key (id_medico) references medico (ci)
	on update cascade on delete cascade
);--alter table tratamiento add column pagado float(2) default 0.0; --esto agregué porque ya tenía datos

create table historial(
	id serial primary key,
	detalle text not null,
	fecha_hora timestamp default current_timestamp,
	id_tratamiento int not null,
	foreign key (id_tratamiento) references tratamiento (id)
	on update cascade on delete cascade
);

create table pago_tratamiento(
	id serial primary key,
	fecha_hora timestamp default current_timestamp,
	monto float(2) not null,
        saldo_restante float(2) default 0.0,
	id_tratamiento int not null, foreign key (id_tratamiento) references tratamiento (id)
	on update cascade on delete cascade
);--alter table pago_tratamiento add column saldo_restante float(2) default 0.0; --lo agregué después no más
