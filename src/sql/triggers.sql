CREATE OR REPLACE FUNCTION public.create_historial_clinico()
  RETURNS trigger AS
$$		
BEGIN
   insert into historial_clinico (id_paciente) values (new.ci);
   RETURN NEW;
END;
$$
LANGUAGE plpgsql
;
CREATE TRIGGER create_historial_clinico_after_insert AFTER INSERT
  ON paciente
  FOR EACH ROW
EXECUTE PROCEDURE create_historial_clinico()
;