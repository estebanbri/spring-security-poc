INSERT INTO rol (id, nombre, descripcion, enabled)
values(1,'ROLE_ADMIN', 'Rol Administrador', 1);
INSERT INTO rol (id, nombre, descripcion, enabled)
values(2,'ROLE_ALUMNO', 'Rol Alumno', 1);

INSERT INTO usuario (id, login, password, nombre, apellido, email, enabled, role_id)
values(1,'briceo.ignacio', '9195','Ignacio','Briceno','esteban@hotmail.com', 1, 1);
INSERT INTO usuario (id, login, password, nombre, apellido, email, enabled, role_id)
values(2,'sati.andres', '9195','Andres','Sati','andres@gmail.com', 1, 2);

INSERT INTO permiso (id, nombre, descripcion, enabled)
values(10,'VIEWHOME', 'Permiso de solo lectura del home', 1);
INSERT INTO permiso (id, nombre, descripcion, enabled)
values(20,'EDITHOME', 'Permiso de edición del home', 1);

INSERT INTO rol_permiso (id_rol, id_permiso)
values(1,10);
INSERT INTO rol_permiso (id_rol, id_permiso)
values(1,20);
INSERT INTO rol_permiso (id_rol, id_permiso)
values(2,10);

