using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace Explore_AgenciaAPI.Migrations
{
    public partial class TodosController01 : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.RenameColumn(
                name: "Id_cargo",
                table: "Usuarios",
                newName: "id_cargo");

            migrationBuilder.RenameColumn(
                name: "Id_cidade",
                table: "Pacotes",
                newName: "id_cidade");

            migrationBuilder.AlterColumn<int>(
                name: "id_cargo",
                table: "Usuarios",
                type: "int",
                nullable: true,
                oldClrType: typeof(long),
                oldType: "bigint");

            migrationBuilder.AlterColumn<int>(
                name: "id_cidade",
                table: "Pacotes",
                type: "int",
                nullable: true,
                oldClrType: typeof(long),
                oldType: "bigint");

            migrationBuilder.CreateIndex(
                name: "IX_Usuarios_id_cargo",
                table: "Usuarios",
                column: "id_cargo");

            migrationBuilder.CreateIndex(
                name: "IX_Pacotes_id_cidade",
                table: "Pacotes",
                column: "id_cidade");

            migrationBuilder.AddForeignKey(
                name: "FK_Pacotes_Cidades_id_cidade",
                table: "Pacotes",
                column: "id_cidade",
                principalTable: "Cidades",
                principalColumn: "Id");

            migrationBuilder.AddForeignKey(
                name: "FK_Usuarios_Cargos_id_cargo",
                table: "Usuarios",
                column: "id_cargo",
                principalTable: "Cargos",
                principalColumn: "Id");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_Pacotes_Cidades_id_cidade",
                table: "Pacotes");

            migrationBuilder.DropForeignKey(
                name: "FK_Usuarios_Cargos_id_cargo",
                table: "Usuarios");

            migrationBuilder.DropIndex(
                name: "IX_Usuarios_id_cargo",
                table: "Usuarios");

            migrationBuilder.DropIndex(
                name: "IX_Pacotes_id_cidade",
                table: "Pacotes");

            migrationBuilder.RenameColumn(
                name: "id_cargo",
                table: "Usuarios",
                newName: "Id_cargo");

            migrationBuilder.RenameColumn(
                name: "id_cidade",
                table: "Pacotes",
                newName: "Id_cidade");

            migrationBuilder.AlterColumn<long>(
                name: "Id_cargo",
                table: "Usuarios",
                type: "bigint",
                nullable: false,
                defaultValue: 0L,
                oldClrType: typeof(int),
                oldType: "int",
                oldNullable: true);

            migrationBuilder.AlterColumn<long>(
                name: "Id_cidade",
                table: "Pacotes",
                type: "bigint",
                nullable: false,
                defaultValue: 0L,
                oldClrType: typeof(int),
                oldType: "int",
                oldNullable: true);
        }
    }
}
