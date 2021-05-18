--
-- PostgreSQL database dump
--

-- Dumped from database version 13.1
-- Dumped by pg_dump version 13.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: kullanici; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.kullanici (
    id integer NOT NULL,
    "Ad" character varying(50) NOT NULL,
    "Soyad" character varying(50) NOT NULL,
    "KullaniciAdi" character varying(50) NOT NULL,
    "Sifre" character varying(16) NOT NULL
);


ALTER TABLE public.kullanici OWNER TO postgres;

--
-- Name: view1; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.view1 AS
 SELECT kullanici."Ad",
    kullanici."Soyad"
   FROM public.kullanici;


ALTER TABLE public.view1 OWNER TO postgres;

--
-- Data for Name: kullanici; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.kullanici VALUES
	(1, 'İbrahim', 'Kuru', 'atfkr', '123'),
	(2, 'Hüseyin', 'Dede', 'hdede', '456');


--
-- Name: kullanici kullanici_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.kullanici
    ADD CONSTRAINT kullanici_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

