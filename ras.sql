-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-07-2025 a las 21:18:03
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ras`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ambiente`
--

CREATE TABLE `ambiente` (
  `cod_amb` int(11) NOT NULL,
  `nom_amb` varchar(255) DEFAULT NULL,
  `capacidad_amb` int(11) DEFAULT NULL,
  `piso_amb` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ambiente`
--

INSERT INTO `ambiente` (`cod_amb`, `nom_amb`, `capacidad_amb`, `piso_amb`) VALUES
(3, 'Ambiente', 20, '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `calificacion_evento`
--

CREATE TABLE `calificacion_evento` (
  `cod_calificacion` int(11) NOT NULL,
  `ambi_calificacion` int(11) DEFAULT NULL,
  `evento_calificacion` int(11) DEFAULT NULL,
  `organizacion_calificacion` int(11) DEFAULT NULL,
  `comentarios_evento` varchar(256) DEFAULT NULL,
  `cod_reserva` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cargo_funcionario`
--

CREATE TABLE `cargo_funcionario` (
  `cod_cargo_func` int(11) NOT NULL,
  `cargo_func` varchar(35) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `centro_formacion`
--

CREATE TABLE `centro_formacion` (
  `cod_centro` int(11) NOT NULL,
  `nom_centro` varchar(40) NOT NULL,
  `direccion_centro` varchar(60) NOT NULL,
  `ciudad_centro` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `centro_formacion`
--

INSERT INTO `centro_formacion` (`cod_centro`, `nom_centro`, `direccion_centro`, `ciudad_centro`) VALUES
(1, 'Centro de Servicios Financieros', 'Kr 13 #65 10', 'Bogotá');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `coordinacion`
--

CREATE TABLE `coordinacion` (
  `cod_coordinacion` int(11) NOT NULL,
  `nombre_coordinacion` varchar(35) DEFAULT NULL,
  `cod_centro` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `funcionario`
--

CREATE TABLE `funcionario` (
  `cod_funcionario` bigint(20) NOT NULL,
  `cod_usuario` bigint(20) DEFAULT NULL,
  `cod_coordinacion` int(11) DEFAULT NULL,
  `cod_cargo_func` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `cod_reserva` int(11) NOT NULL,
  `titulo_evento` varchar(100) DEFAULT NULL,
  `tipo_evento` varchar(256) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `hora_i` time DEFAULT NULL,
  `hora_f` time DEFAULT NULL,
  `motivo` varchar(256) DEFAULT NULL,
  `num_personas` int(11) DEFAULT NULL,
  `cod_usuario` bigint(20) DEFAULT NULL,
  `cod_funcionario` bigint(20) DEFAULT NULL,
  `cod_amb` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_usuario`
--

CREATE TABLE `tbl_usuario` (
  `cod_usuario` bigint(20) NOT NULL,
  `tipo_docu` varchar(255) DEFAULT NULL,
  `num_docu` int(11) DEFAULT NULL,
  `nomb_comple` varchar(255) DEFAULT NULL,
  `apelli_comple` varchar(255) DEFAULT NULL,
  `telefono` bigint(20) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `rol_usuario` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tbl_usuario`
--

INSERT INTO `tbl_usuario` (`cod_usuario`, `tipo_docu`, `num_docu`, `nomb_comple`, `apelli_comple`, `telefono`, `email`, `password`, `rol_usuario`) VALUES
(1, 'CC', 1141715231, 'Samuel Alejandro', 'Peña Pineda', 3202901257, 'penas6422@gmail.com', '$2a$10$7ai6HE1gn2JMkRhpFHTHR.e68m6clnGLLx2h1zQYDYigbtt6AGGFq', 'Usuario'),
(2, 'TI', 10123123, 'Edson', 'Vega', 3202901257, 'edjo114@correo.com', '$2a$10$mstENW2ECAOB6N6sWVGi0uSGByJOUGUvCSfOFC3wTfxVOejNpl1fS', 'Usuario');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ambiente`
--
ALTER TABLE `ambiente`
  ADD PRIMARY KEY (`cod_amb`);

--
-- Indices de la tabla `calificacion_evento`
--
ALTER TABLE `calificacion_evento`
  ADD PRIMARY KEY (`cod_calificacion`),
  ADD KEY `cod_reserva` (`cod_reserva`);

--
-- Indices de la tabla `cargo_funcionario`
--
ALTER TABLE `cargo_funcionario`
  ADD PRIMARY KEY (`cod_cargo_func`);

--
-- Indices de la tabla `centro_formacion`
--
ALTER TABLE `centro_formacion`
  ADD PRIMARY KEY (`cod_centro`);

--
-- Indices de la tabla `coordinacion`
--
ALTER TABLE `coordinacion`
  ADD PRIMARY KEY (`cod_coordinacion`),
  ADD KEY `cod_centro` (`cod_centro`);

--
-- Indices de la tabla `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`cod_funcionario`),
  ADD KEY `cod_usuario` (`cod_usuario`),
  ADD KEY `cod_coordinacion` (`cod_coordinacion`),
  ADD KEY `cod_cargo_func` (`cod_cargo_func`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`cod_reserva`),
  ADD KEY `cod_usuario` (`cod_usuario`),
  ADD KEY `cod_funcionario` (`cod_funcionario`),
  ADD KEY `cod_amb` (`cod_amb`);

--
-- Indices de la tabla `tbl_usuario`
--
ALTER TABLE `tbl_usuario`
  ADD PRIMARY KEY (`cod_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ambiente`
--
ALTER TABLE `ambiente`
  MODIFY `cod_amb` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `calificacion_evento`
--
ALTER TABLE `calificacion_evento`
  MODIFY `cod_calificacion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cargo_funcionario`
--
ALTER TABLE `cargo_funcionario`
  MODIFY `cod_cargo_func` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `centro_formacion`
--
ALTER TABLE `centro_formacion`
  MODIFY `cod_centro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `coordinacion`
--
ALTER TABLE `coordinacion`
  MODIFY `cod_coordinacion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `cod_funcionario` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `cod_reserva` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbl_usuario`
--
ALTER TABLE `tbl_usuario`
  MODIFY `cod_usuario` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `calificacion_evento`
--
ALTER TABLE `calificacion_evento`
  ADD CONSTRAINT `calificacion_evento_ibfk_1` FOREIGN KEY (`cod_reserva`) REFERENCES `reserva` (`cod_reserva`);

--
-- Filtros para la tabla `coordinacion`
--
ALTER TABLE `coordinacion`
  ADD CONSTRAINT `coordinacion_ibfk_1` FOREIGN KEY (`cod_centro`) REFERENCES `centro_formacion` (`cod_centro`);

--
-- Filtros para la tabla `funcionario`
--
ALTER TABLE `funcionario`
  ADD CONSTRAINT `funcionario_ibfk_1` FOREIGN KEY (`cod_usuario`) REFERENCES `tbl_usuario` (`cod_usuario`),
  ADD CONSTRAINT `funcionario_ibfk_2` FOREIGN KEY (`cod_coordinacion`) REFERENCES `coordinacion` (`cod_coordinacion`),
  ADD CONSTRAINT `funcionario_ibfk_3` FOREIGN KEY (`cod_cargo_func`) REFERENCES `cargo_funcionario` (`cod_cargo_func`);

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`cod_usuario`) REFERENCES `tbl_usuario` (`cod_usuario`),
  ADD CONSTRAINT `reserva_ibfk_2` FOREIGN KEY (`cod_funcionario`) REFERENCES `funcionario` (`cod_funcionario`),
  ADD CONSTRAINT `reserva_ibfk_3` FOREIGN KEY (`cod_amb`) REFERENCES `ambiente` (`cod_amb`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
