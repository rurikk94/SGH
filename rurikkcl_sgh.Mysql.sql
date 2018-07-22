-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-07-2018 a las 09:38:24
-- Versión del servidor: 10.1.33-MariaDB
-- Versión de PHP: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `rurikkcl_sgh`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cama`
--

CREATE TABLE `cama` (
  `numeroCama` int(11) NOT NULL,
  `idHabitacion` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `camaDisponible` int(11) NOT NULL,
  `especialidad` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `rutPaciente` int(11) DEFAULT NULL,
  `dv` varchar(1) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `cama`
--

INSERT INTO `cama` (`numeroCama`, `idHabitacion`, `camaDisponible`, `especialidad`, `rutPaciente`, `dv`) VALUES
(100, 'C1', 0, 'Neuro', 4567852, '0'),
(101, 'C2', 1, 'Algo', NULL, NULL),
(300, 'H1', 1, 'General', NULL, NULL),
(301, 'H1', 1, NULL, NULL, NULL),
(302, 'H1', 1, NULL, NULL, NULL),
(303, 'H1', 1, NULL, NULL, NULL),
(304, 'H1', 1, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `camahospitalizados`
--

CREATE TABLE `camahospitalizados` (
  `numeroCama` int(11) NOT NULL,
  `idHospitalizadoCama` varchar(50) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consulta`
--

CREATE TABLE `consulta` (
  `idConsulta` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `disponibilidad` int(11) NOT NULL,
  `especialidad` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `numeroCama` int(11) DEFAULT NULL,
  `rutMedico` int(11) DEFAULT NULL,
  `dv` varchar(1) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `consulta`
--

INSERT INTO `consulta` (`idConsulta`, `disponibilidad`, `especialidad`, `numeroCama`, `rutMedico`, `dv`) VALUES
('C1', 0, 'Neurocirujia', 100, 1234545, '3'),
('C2', 1, 'EspecialidadAlgo', 101, 4567888, '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `enfermeros`
--

CREATE TABLE `enfermeros` (
  `rut` int(11) NOT NULL,
  `dv` char(1) COLLATE utf8_spanish_ci NOT NULL,
  `nombres` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `fechaNac` date NOT NULL,
  `telefono` int(11) DEFAULT NULL,
  `email` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `enfermeros`
--

INSERT INTO `enfermeros` (`rut`, `dv`, `nombres`, `apellidos`, `fechaNac`, `telefono`, `email`) VALUES
(1000100, '5', 'Aribert', 'Heim', '1914-01-05', 0, 'd@c.muerte'),
(9708357, '6', 'Juan Al', 'Perez', '1958-05-24', 12345678, 'email@user.cl'),
(11451850, '6', 'Irena', 'Sendler', '1910-01-05', 0, 'irena@sendler.com'),
(12345678, '5', 'Ana', 'Mar', '1978-05-24', 45678912, 'email2@tuemail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hospitalizados`
--

CREATE TABLE `hospitalizados` (
  `idHospitalizados` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `disponibilidad` int(11) NOT NULL,
  `especialidad` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `capacidad` int(11) NOT NULL,
  `rutEnfermero` int(11) NOT NULL,
  `dv` varchar(1) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `hospitalizados`
--

INSERT INTO `hospitalizados` (`idHospitalizados`, `disponibilidad`, `especialidad`, `capacidad`, `rutEnfermero`, `dv`) VALUES
('H1', 1, 'General', 5, 12345678, '5');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `listapacientes`
--

CREATE TABLE `listapacientes` (
  `rutMedico` int(11) NOT NULL,
  `rutPaciente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `listapacientes`
--

INSERT INTO `listapacientes` (`rutMedico`, `rutPaciente`) VALUES
(10101010, 1461946),
(10101010, 4567852);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicos`
--

CREATE TABLE `medicos` (
  `rut` int(11) NOT NULL,
  `dv` char(1) COLLATE utf8_spanish_ci NOT NULL,
  `nombres` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `fechaNac` date NOT NULL,
  `telefono` int(11) DEFAULT NULL,
  `email` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `especialidad` varchar(50) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `medicos`
--

INSERT INTO `medicos` (`rut`, `dv`, `nombres`, `apellidos`, `fechaNac`, `telefono`, `email`, `especialidad`) VALUES
(1234545, '3', 'Stephen', 'Strange', '1963-12-24', 4567896, 'tiempo@wea.com', 'Neurocirujía'),
(4567888, '1', 'Gregory', 'House', '1980-12-24', 456789456, 'emaiqk@gmail.comqwe', 'Carnicería'),
(7857895, '5', 'John', 'Watson', '1955-12-24', 55122419, 'emailcito@akw.kr', 'General'),
(10101010, '4', 'Sara', 'Tancredi', '1985-10-15', 54685798, 'sara@tra.cl', 'General'),
(12456785, '8', 'Derek', 'Shepherd', '1966-12-24', 13011966, 'emailcito@akw.kr', 'Neurocirujía'),
(12545656, '1', 'asdasdasd', 'Hibbert', '1975-10-15', 12545656, 'LACTM', 'Pediatría'),
(17456456, '6', 'Shaun', 'Murphy', '1989-12-24', 45454545, 'emailcito@akw.kr', 'General');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pacientes`
--

CREATE TABLE `pacientes` (
  `rut` int(11) NOT NULL,
  `dv` char(1) COLLATE utf8_spanish_ci NOT NULL,
  `nombres` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `fechaNac` date NOT NULL,
  `telefono` int(11) DEFAULT NULL,
  `nombreContacto` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefonoContacto` int(11) NOT NULL,
  `sexo` char(1) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `pacientes`
--

INSERT INTO `pacientes` (`rut`, `dv`, `nombres`, `apellidos`, `fechaNac`, `telefono`, `nombreContacto`, `telefonoContacto`, `sexo`) VALUES
(4567852, '0', 'Carla', 'Peña', '1988-05-24', 64587598, 'Papá', 4585789, 'F'),
(7247396, '5', 'Melina', 'Gata', '1935-06-14', 54234235, 'Perro', 2354346, 'M'),
(16337396, '3', 'Juanitopereza', 'Gigante', '1965-11-11', 12312212, 'Hermanita', 44357343, 'F'),
(20958806, '4', 'Anastacia', 'Nyaa', '1975-06-14', 524587, 'Gato', 231221, 'M');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cama`
--
ALTER TABLE `cama`
  ADD PRIMARY KEY (`numeroCama`);

--
-- Indices de la tabla `camahospitalizados`
--
ALTER TABLE `camahospitalizados`
  ADD PRIMARY KEY (`numeroCama`,`idHospitalizadoCama`);

--
-- Indices de la tabla `consulta`
--
ALTER TABLE `consulta`
  ADD PRIMARY KEY (`idConsulta`);

--
-- Indices de la tabla `enfermeros`
--
ALTER TABLE `enfermeros`
  ADD PRIMARY KEY (`rut`);

--
-- Indices de la tabla `hospitalizados`
--
ALTER TABLE `hospitalizados`
  ADD PRIMARY KEY (`idHospitalizados`);

--
-- Indices de la tabla `listapacientes`
--
ALTER TABLE `listapacientes`
  ADD PRIMARY KEY (`rutMedico`,`rutPaciente`);

--
-- Indices de la tabla `medicos`
--
ALTER TABLE `medicos`
  ADD PRIMARY KEY (`rut`);

--
-- Indices de la tabla `pacientes`
--
ALTER TABLE `pacientes`
  ADD PRIMARY KEY (`rut`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
