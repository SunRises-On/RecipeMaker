import React from 'react';
import './styles/HomeStyle.css';
import tin from './resources/recipe-tin.png';
import Image from 'react-bootstrap/Image';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';

import { Container } from 'react-bootstrap';


export default function Home(){
    return(
            <div className="main">
                <Container maxWidth="sm">
                    <div className="d-flex flex-column min-vh-100 justify-content-center align-items-center"
                    >
                        <Card style={{width: '20rem' ,backgroundColor: 'gainsboro', border: 'none'}}
                            className="mx-auto my-auto p5"
                        >
                            <Card.Img variant='top'
                                  src={tin}
                            />
                            <Card.Body>
                            <Button variant="primary">
                                Enter
                            </Button>
                            </Card.Body>
                        </Card>
                    </div>
                </Container>
            </div>

    );
}