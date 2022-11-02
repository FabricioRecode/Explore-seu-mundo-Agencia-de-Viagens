﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Explore_AgenciaAPI.Model;
using Explore_AgenciaAPI.Models;

namespace Explore_AgenciaAPI.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class PacoteController : ControllerBase
    {
        private readonly GeralDBContext _context;

        public PacoteController(GeralDBContext context)
        {
            _context = context;
        }

        // GET: api/Pacote
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Pacote>>> GetPacotes()
        {
            return await _context.Pacotes.ToListAsync();
        }

        // GET: api/Pacote/5
        [HttpGet("{id}")]
        public async Task<ActionResult<Pacote>> GetPacote(int id)
        {
            var pacote = await _context.Pacotes.FindAsync(id);

            if (pacote == null)
            {
                return NotFound();
            }

            return pacote;
        }

        // PUT: api/Pacote/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutPacote(int id, Pacote pacote)
        {
            if (id != pacote.Id)
            {
                return BadRequest();
            }

            _context.Entry(pacote).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!PacoteExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        // POST: api/Pacote
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<Pacote>> PostPacote(Pacote pacote)
        {
            _context.Pacotes.Add(pacote);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetPacote", new { id = pacote.Id }, pacote);
        }

        // DELETE: api/Pacote/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeletePacote(int id)
        {
            var pacote = await _context.Pacotes.FindAsync(id);
            if (pacote == null)
            {
                return NotFound();
            }

            _context.Pacotes.Remove(pacote);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool PacoteExists(int id)
        {
            return _context.Pacotes.Any(e => e.Id == id);
        }
    }
}
