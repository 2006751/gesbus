import React, { useState, useEffect } from 'react';
import { Link, useHistory } from 'react-router-dom';
import { FiPower, FiEdit, FiTrash2 } from 'react-icons/fi'
import SettingsMenu from '../Menu/SettingsMenu';

import api from '../../services/api'

import './styles.css';

import logoImage from '../../assets/logo.svg'

export default function Veiculos(){

    const [veiculos, setVeiculos] = useState([]);
    const [page, setPage] = useState(1);
    
    const nome = localStorage.getItem('nome');
    const accessToken = localStorage.getItem('accessToken');

    const history = useHistory();

      async function editVeiculo(id) {
        try {
            history.push('veiculo/new/${id}')
        } catch (error) {
            alert('Edit failed! Try again.');
        }
    }
    async function deleteVeiculo(id) {
        try {
            await api.delete('veiculo/${id}', {
                headers: {
                    Authorization: `Bearer ${accessToken}`
                }
            })

            setVeiculos(veiculos.filter(veiculo => veiculo.id !== id))
        } catch (err) {
            alert('Delete failed! Try again.');
        }
    }

    async function fetchMoreVeiculos() {
        const response = await api.get('veiculo', {
            headers: {
                Authorization: `Bearer ${accessToken}`
            },
            params: {
                page: page,
                limit: 4,
                direction: 'asc'
            }
        });

        setVeiculos([ ...veiculos, ...response.data._embedded.veiculos])
        setPage(page + 1);
    }

    useEffect(() => {
        fetchMoreVeiculos();
    }, [])
    
    return (
        <div className="book-container">
			<SettingsMenu />
            <header>
                <img src={logoImage} alt="GesBus"/>
                <span>Bem-vindo, <strong>{nome.toUpperCase()}</strong>!</span>
                <Link className="button" to="veiculo/new/0">Adiciona Veículo</Link>
            </header>

            <h1>Veículos</h1>
            <ul>
                {veiculos.map(veiculo => (
                    <li key={veiculo.id}>
                        <strong>Placa:</strong>
                        <p>{veiculo.placa}</p>
                        <strong>Identificação:</strong>
                        <p>{veiculo.identificacao}</p>
                        <strong>Marca:</strong>
                        <p>{veiculo.marca}</p>
                        <strong>Modelo:</strong>
                        <p>{veiculo.modelo}</p>
                        <strong>Ano de Fabricação:</strong>
                        <p>{veiculo.anoDeFabricacao}</p>
                        
                        <button onClick={() => editVeiculo(veiculo.id)} type="button">
                            <FiEdit size={20} color="#251FC5"/>
                        </button>
                        
                        <button onClick={() => deleteVeiculo(veiculo.id)} type="button">
                            <FiTrash2 size={20} color="#251FC5"/>
                        </button>
                    </li>
                ))}
            </ul>

            <button className="button" onClick={fetchMoreVeiculos} type="button">Mais...</button>
        </div>
    );
}