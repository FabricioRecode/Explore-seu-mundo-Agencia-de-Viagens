using Explore_AgenciaAPI.Model;
using Microsoft.EntityFrameworkCore;

namespace Explore_AgenciaAPI.Models
{
    public class GeralDBContext : DbContext
    {
        public GeralDBContext(DbContextOptions<GeralDBContext>options)
            : base(options)
        { }


        public DbSet<Cidade> Cidades { get; set; }
        public DbSet<Cargo> Cargos { get; set; }
        public DbSet<Pacote> Pacotes { get; set; }
        public DbSet<Usuario> Usuarios { get; set; }

    }
}
