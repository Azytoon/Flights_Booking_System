CREATE TABLE IF NOT EXISTS flights (
	flight_id UUID PRIMARY KEY NOT NULL DEFAULT uuid_generate_v4(),
	from_city VARCHAR(50)  NOT NULL,
	to_city VARCHAR(50)  NOT NULL,
	fareA INT  NOT NULL,
	fareB INT  NOT NULL,
	departureTime VARCHAR NOT NULL,
	arrivalTime VARCHAR NOT NULL
);
insert into flights (from_city, to_city, fareA, fareB, departureTime, arrivalTime) values ('Tofa', 'Puszczykowo', 7000, 5000, '2021-12-30 20:04:52', '2021-12-28 09:56:59');
insert into flights (from_city, to_city, fareA, fareB, departureTime, arrivalTime) values ('Zhagang', 'Makiwalo', 7500, 5500, '2021-12-31 18:11:23', '2022-01-10 05:00:43');
insert into flights (from_city, to_city, fareA, fareB, departureTime, arrivalTime) values ('Svetogorsk', 'São Carlos', 9000, 7000, '2022-01-28 09:13:52', '2022-01-22 03:33:19');
insert into flights (from_city, to_city, fareA, fareB, departureTime, arrivalTime) values ('Deneysville', 'Van Nuys', 6500, 5000, '2022-01-09 20:39:37', '2022-01-03 13:25:30');
insert into flights (from_city, to_city, fareA, fareB, departureTime, arrivalTime) values ('Tužno', 'Mantang', 5500, 4000, '2021-12-25 18:00:28', '2022-01-15 13:04:14');
insert into flights (from_city, to_city, fareA, fareB, departureTime, arrivalTime) values ('Betio Village', 'Lameiro', 3500, 3000, '2021-12-04 16:36:33', '2022-01-05 18:12:34');
insert into flights (from_city, to_city, fareA, fareB, departureTime, arrivalTime) values ('Gonghe', 'Rossosh’', 5500, 4500, '2022-01-08 11:54:42', '2022-01-19 20:29:25');
insert into flights (from_city, to_city, fareA, fareB, departureTime, arrivalTime) values ('Uyovu', 'Sandviken', 8400, 7400, '2022-01-06 13:12:46', '2022-01-14 11:38:09');
insert into flights (from_city, to_city, fareA, fareB, departureTime, arrivalTime) values ('Progër', 'Cimenga', 6000, 5000, '2021-12-16 13:41:30', '2022-01-22 07:01:55');
insert into flights (from_city, to_city, fareA, fareB, departureTime, arrivalTime) values ('Zarzis', 'Santo Domingo', 9300, 7300, '2021-12-08 14:17:57', '2022-01-19 19:32:43');
insert into flights (from_city, to_city, fareA, fareB, departureTime, arrivalTime) values ('Yutsa', 'Kanthararom', 8500, 7500, '2021-12-31 22:36:27', '2021-12-29 15:03:11');
insert into flights (from_city, to_city, fareA, fareB, departureTime, arrivalTime) values ('Nezlobnaya', 'Paris 02', 11000, 9000, '2022-01-06 00:50:09', '2021-12-25 01:12:42');
insert into flights (from_city, to_city, fareA, fareB, departureTime, arrivalTime) values ('Cililitan', 'Valence', 6000, 5000, '2021-12-03 14:23:57', '2021-12-05 12:26:58');
insert into flights (from_city, to_city, fareA, fareB, departureTime, arrivalTime) values ('Nyinqug', 'Saint-Étienne', 4200, 3500, '2021-12-21 18:50:19', '2022-01-22 02:25:07');
insert into flights (from_city, to_city, fareA, fareB, departureTime, arrivalTime) values ('Wolanów', 'Ōmachi', 15000, 12500, '2022-01-12 15:16:21', '2022-01-17 14:01:58');
insert into flights (from_city, to_city, fareA, fareB, departureTime, arrivalTime) values ('Berlin', 'Mandepa Barat', 6800, 5000, '2022-01-19 01:09:34', '2021-12-14 09:55:13');
insert into flights (from_city, to_city, fareA, fareB, departureTime, arrivalTime) values ('Lushan', 'Ambulong', 8700, 5900, '2022-01-07 17:44:45', '2021-12-25 15:20:58');
insert into flights (from_city, to_city, fareA, fareB, departureTime, arrivalTime) values ('Nanfeng', 'Sandia', 8020, 7000, '2021-12-22 16:24:43', '2022-01-01 10:36:03');
insert into flights (from_city, to_city, fareA, fareB, departureTime, arrivalTime) values ('Shijak', 'Lushan', 11000, 9000, '2022-01-03 03:27:53', '2021-12-05 04:21:45');
insert into flights (from_city, to_city, fareA, fareB, departureTime, arrivalTime) values ('Shicheng', 'Ketapang', 10000, 9000, '2021-12-01 01:00:40', '2021-11-30 21:22:20');
insert into flights (from_city, to_city, fareA, fareB, departureTime, arrivalTime) values ('Grebnevo', 'Póvoa', 7500, 6000, '2022-01-11 15:26:14', '2021-12-06 06:38:28');
insert into flights (from_city, to_city, fareA, fareB, departureTime, arrivalTime) values ('Talhar', 'Boyang', 3700, 3400, '2021-12-11 19:50:02', '2022-01-17 17:30:59');
insert into flights (from_city, to_city, fareA, fareB, departureTime, arrivalTime) values ('Isheyevka', 'Turku', 11000, 8500, '2022-01-23 01:47:40', '2021-12-24 08:10:46');
insert into flights (from_city, to_city, fareA, fareB, departureTime, arrivalTime) values ('Plasy', 'Tsukumiura', 3000, 2700, '2021-12-02 10:31:20', '2021-12-22 09:59:18');
insert into flights (from_city, to_city, fareA, fareB, departureTime, arrivalTime) values ('Saint-Dié-des-Vosges', 'Nakhchivan', 8200, 7000, '2022-01-11 19:47:35', '2022-01-02 16:17:52');
insert into flights (from_city, to_city, fareA, fareB, departureTime, arrivalTime) values ('Noisy-le-Grand', 'Porta', 4900, 3500, '2021-12-04 03:50:12', '2022-01-27 06:50:29');
insert into flights (from_city, to_city, fareA, fareB, departureTime, arrivalTime) values ('Wan’an', 'Dzerzhinsk', 4500, 4000, '2022-01-05 06:12:27', '2021-11-30 12:23:00');
insert into flights (from_city, to_city, fareA, fareB, departureTime, arrivalTime) values ('Marly', 'Huancheng', 4000, 3500, '2022-01-07 02:24:41', '2022-01-05 16:32:27');
insert into flights (from_city, to_city, fareA, fareB, departureTime, arrivalTime) values ('Sann', 'Kalisari', 4700, 3800, '2022-01-27 16:41:44', '2022-01-09 07:31:55');
insert into flights (from_city, to_city, fareA, fareB, departureTime, arrivalTime) values ('Čair', 'Ashibetsu', 7700, 3500, '2021-12-09 04:30:48', '2021-12-23 10:58:16');
